package ee.parking.parkingbillingapp.usecase.invoice.service;

import ee.parking.parkingbillingapp.usecase.report.model.Report;
import ee.parking.parkingbillingapp.usecase.report.service.ReportRowService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceService {

    final
    InvoicePdfGeneratorService invoicePdfGeneratorService;

    final
    ReportRowService reportRowService;

    public InvoiceService(InvoicePdfGeneratorService invoicePdfGeneratorService, ReportRowService reportRowService) {
        this.invoicePdfGeneratorService = invoicePdfGeneratorService;
        this.reportRowService = reportRowService;
    }

    public byte[] getInvoicePdf(Long customerId) {
        Map<String, Object> reportMap = new HashMap<>();
        Report customerReport = reportRowService.getCustomerReport(customerId);
        if(customerReport == null) {
            return null;
        }

        reportMap.put("report", customerReport);
        return invoicePdfGeneratorService.generateInvoicePdf("invoice", reportMap, "invoice.pdf");
    }

}
