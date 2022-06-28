package ee.parking.parkingbillingapp.usecase.invoice.service;


import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.util.Map;

@Service
public class InvoicePdfGeneratorService {
    private Logger logger = LoggerFactory.getLogger(InvoicePdfGeneratorService.class);

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] generateInvoicePdf(String templateName, Map<String, Object> data, String pdfFileName) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream (1024);

        Context context = new Context();
        context.setVariables(data);

        String htmlContent = templateEngine.process(templateName, context);

        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream, false);
            renderer.finishPDF();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return outputStream.toByteArray();

    }
}
