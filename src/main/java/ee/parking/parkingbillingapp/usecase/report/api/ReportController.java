package ee.parking.parkingbillingapp.usecase.report.api;

import ee.parking.parkingbillingapp.usecase.invoice.api.InvoiceController;
import ee.parking.parkingbillingapp.usecase.report.model.Report;
import ee.parking.parkingbillingapp.usecase.report.model.ReportQuery;
import ee.parking.parkingbillingapp.usecase.report.service.ReportRowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/report")
public class ReportController {

    private Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final ReportRowService reportRowService;

    public ReportController(ReportRowService reportRowService) {
        this.reportRowService = reportRowService;
    }

    @GetMapping("/{customerId}")
    ResponseEntity<Object> getReport(@PathVariable Long customerId) {
        Report report = reportRowService.getCustomerReport(customerId);
        if (report != null) {
          return new ResponseEntity<>(report, HttpStatus.OK);
        }

        logger.info("Parking report not found for customerId " + customerId);

        return new ResponseEntity<>(
                "REPORT NOT FOUND!", HttpStatus.NOT_FOUND);
    }


}
