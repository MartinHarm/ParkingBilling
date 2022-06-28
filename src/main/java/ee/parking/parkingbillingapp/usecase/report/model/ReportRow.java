package ee.parking.parkingbillingapp.usecase.report.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ReportRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime parkingStarted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime parkingEnded;

    private String facility;

    private BigDecimal cost;

    @Column(name = "report_id")
    private Long reportId;

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getParkingStarted() {
        return parkingStarted;
    }

    public void setParkingStarted(LocalDateTime parkingStarted) {
        this.parkingStarted = parkingStarted;
    }

    public LocalDateTime getParkingEnded() {
        return parkingEnded;
    }

    public void setParkingEnded(LocalDateTime parkingEnded) {
        this.parkingEnded = parkingEnded;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

}
