package ee.parking.parkingbillingapp.usecase.report.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReportQuery {

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportStart;

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportEnd;

    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReportStart() {
        return reportStart;
    }

    public void setReportStart(LocalDateTime reportStart) {
        this.reportStart = reportStart;
    }

    public LocalDateTime getReportEnd() {
        return reportEnd;
    }

    public void setReportEnd(LocalDateTime reportEnd) {
        this.reportEnd = reportEnd;
    }
}
