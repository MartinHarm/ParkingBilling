package ee.parking.parkingbillingapp.usecase.invoice.model;

import java.util.List;

public class InvoiceQuery {
    private List<Long> reportRowIds;

    private Long customerId;

    public List<Long> getReportRowIds() {
        return reportRowIds;
    }

    public void setReportRowIds(List<Long> reportRowIds) {
        this.reportRowIds = reportRowIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
