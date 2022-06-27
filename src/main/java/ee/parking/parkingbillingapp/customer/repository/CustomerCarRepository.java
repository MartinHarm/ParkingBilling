package ee.parking.parkingbillingapp.customer.repository;

import ee.parking.parkingbillingapp.customer.model.CustomerCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCarRepository extends CrudRepository<CustomerCar, Long> {
    CustomerCar findByRegNumber(String regNumber);
}
