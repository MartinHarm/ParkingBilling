package ee.parking.parkingbillingapp.usecase.invoice.api;

import ee.parking.parkingbillingapp.usecase.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/invoice")
public class InvoiceController {

    private Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("generate/{customerId}")
    ResponseEntity<Object> getReport(@PathVariable Long customerId) {

        byte[] contents = invoiceService.getInvoicePdf(customerId);

        if (contents == null) {
            logger.info("Customer report not found for customerID:" + customerId);
            return new ResponseEntity<>("CUSTOMER REPORT NOT FOUND", HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        String filename = "invoice.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
}
