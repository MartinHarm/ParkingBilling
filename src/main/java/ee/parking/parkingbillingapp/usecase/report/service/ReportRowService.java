package ee.parking.parkingbillingapp.usecase.report.service;

import ee.parking.parkingbillingapp.customer.model.Customer;
import ee.parking.parkingbillingapp.customer.model.CustomerType;
import ee.parking.parkingbillingapp.customer.service.CustomerService;
import ee.parking.parkingbillingapp.pricelist.model.FeeType;
import ee.parking.parkingbillingapp.pricelist.service.PricelistService;
import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLog;
import ee.parking.parkingbillingapp.usecase.report.model.Report;
import ee.parking.parkingbillingapp.usecase.report.model.ReportRow;
import ee.parking.parkingbillingapp.usecase.report.repository.ReportRepository;
import ee.parking.parkingbillingapp.usecase.report.repository.ReportRowRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ReportRowService {

    public static final int PREMIUM_CUSTOMER_MAXIMUM_INVOICE = 300;
    private final ReportRowRepository repository;
    private final ReportRepository reportRepository;
    private final PricelistService pricelistService;
    private final CustomerService customerService;

    public ReportRowService(ReportRowRepository repository,
                            ReportRepository reportRepository,
                            PricelistService pricelistService,
                            CustomerService customerService) {
        this.repository = repository;
        this.reportRepository = reportRepository;
        this.pricelistService = pricelistService;
        this.customerService = customerService;
    }

    public Report getCustomerReport(Long customerId) {

        Report customerReport = reportRepository.findByCustomerId(customerId);

        if (customerReport == null) {
            return null;
        }

        if (customerReport.getCustomer().getCustomerType().equals(CustomerType.PREMIUM)) {
            ReportRow fixedPriceReportRow = new ReportRow();

            BigDecimal fixedFee = pricelistService.getFixedPrice(FeeType.MONTHLY, customerReport.getCustomer().getCustomerType());
            fixedPriceReportRow.setCost(fixedFee);

            customerReport.setInvoiceTotal(customerReport.getInvoiceTotal().add(fixedFee));
            customerReport.setInvoiceTotalWithTax(customerReport.getInvoiceTotalWithTax().add(fixedFee.multiply(BigDecimal.valueOf(1.2))));

            customerReport.getReportRows().add(fixedPriceReportRow);

            if (customerReport.getInvoiceTotal().compareTo(BigDecimal.valueOf(PREMIUM_CUSTOMER_MAXIMUM_INVOICE)) > 0) {
                customerReport.setInvoiceTotal(BigDecimal.valueOf(PREMIUM_CUSTOMER_MAXIMUM_INVOICE));
                customerReport.setExceedsMaximumInvoice(true);
            }
        }

        return customerReport;
    }

    public void createReportRowForParkingLog(ParkingLog parkingLog) {
        Customer customer = customerService.getCustomerByCarRegNumber(parkingLog.getRegNumber());

        Report report = reportRepository.findByCustomerId(customer.getId());

        if (report == null) {
            report = new Report();
            report.setCustomerId(customer.getId());
            reportRepository.save(report);
        }

        if (report.getInvoiceTotal() == null || report.getInvoiceTotalWithTax() == null) {
            report.setInvoiceTotal(BigDecimal.valueOf(0));
            report.setInvoiceTotalWithTax(BigDecimal.valueOf(0));
        }

        ReportRow reportRow = new ReportRow();

        reportRow.setReportId(report.getId());
        reportRow.setFacility(parkingLog.getFacility());
        reportRow.setRegNumber(parkingLog.getRegNumber());
        reportRow.setParkingStarted(parkingLog.getParkingStarted());
        reportRow.setParkingEnded(parkingLog.getParkingEnded());

        BigDecimal dailyCost = pricelistService.getPriceForParkingLog(FeeType.DAILY, parkingLog.getParkingStarted(), parkingLog.getParkingEnded(), customer.getCustomerType());
        BigDecimal nightlyCost = pricelistService.getPriceForParkingLog(FeeType.NIGHTLY, parkingLog.getParkingStarted(), parkingLog.getParkingEnded(), customer.getCustomerType());

        BigDecimal totalCost = dailyCost.add(nightlyCost);

        reportRow.setCost(totalCost);

        repository.save(reportRow);

        report.setInvoiceTotal(report.getInvoiceTotal().add(totalCost));
        report.setInvoiceTotalWithTax(report.getInvoiceTotalWithTax().add(totalCost.add(totalCost.multiply(BigDecimal.valueOf(0.2)))));

        reportRepository.save(report);

    }

}
