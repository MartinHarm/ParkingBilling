package ee.parking.parkingbillingapp.customer.repository;

import ee.parking.parkingbillingapp.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
