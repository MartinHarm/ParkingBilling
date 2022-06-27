package ee.parking.parkingbillingapp.usecase.parkinglog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ParkingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regNumber;

    private LocalDateTime parkingStarted;

    private LocalDateTime parkingEnded;

    private String facility;

    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
}
