package ee.parking.parkingbillingapp.usecase.parkinglog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ParkingLogDTO {

    private String regNumber;

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime parkingStarted;

    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime parkingEnded;

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
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
}
