package ee.parking.parkingbillingapp.usecase.parkinglog.service;

import ee.parking.parkingbillingapp.customer.model.Customer;
import ee.parking.parkingbillingapp.customer.service.CustomerService;
import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLog;
import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLogDTO;
import ee.parking.parkingbillingapp.usecase.parkinglog.repository.ParkingLogRepository;
import ee.parking.parkingbillingapp.usecase.report.service.ReportRowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParkingLogService {
    private Logger logger = LoggerFactory.getLogger(ParkingLogService.class);

    public static final String FACILITY = "EUROPARK ÜLEMISTE";

    private final ReportRowService reportRowService;

    private final ParkingLogRepository repository;

    private final CustomerService customerService;

    public ParkingLogService(ParkingLogRepository repository, ReportRowService reportRowService, CustomerService customerService) {
        this.repository = repository;
        this.reportRowService = reportRowService;
        this.customerService = customerService;
    }

    public ParkingLog persistParkingLog(ParkingLogDTO parkingLogDTO) {
        ParkingLog parkingLog = new ParkingLog();

        parkingLog.setParkingStarted(parkingLogDTO.getParkingStarted());
        parkingLog.setParkingEnded(parkingLogDTO.getParkingEnded());

        Customer customer = customerService.getCustomerByCarRegNumber(parkingLogDTO.getRegNumber());
        parkingLog.setCustomerId(customer.getId());

        parkingLog.setFacility(FACILITY);
        parkingLog.setRegNumber(parkingLogDTO.getRegNumber());

        repository.save(parkingLog);
        logger.info("ParkingLog created for regNumber:" + parkingLog.getRegNumber() + " and customerId" + customer.getId());


        reportRowService.createReportRowForParkingLog(parkingLog);

        return parkingLog;
    }
}
