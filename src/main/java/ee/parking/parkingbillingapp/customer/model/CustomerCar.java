package ee.parking.parkingbillingapp.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerCar {

    @Id
    private String regNumber;

    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

}
