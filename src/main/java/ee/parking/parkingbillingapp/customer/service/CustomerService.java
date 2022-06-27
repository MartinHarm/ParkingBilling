package ee.parking.parkingbillingapp.customer.service;

import ee.parking.parkingbillingapp.customer.model.Customer;
import ee.parking.parkingbillingapp.customer.model.CustomerCar;
import ee.parking.parkingbillingapp.customer.repository.CustomerCarRepository;
import ee.parking.parkingbillingapp.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    final CustomerCarRepository customerCarRepository;

    public CustomerService(CustomerCarRepository customerCarRepository, CustomerRepository customerRepository) {
        this.customerCarRepository = customerCarRepository;
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer getCustomerByCarRegNumber(String regNumber) {
        CustomerCar customerCar = customerCarRepository.findByRegNumber(regNumber);
        return customerRepository.findById(customerCar.getCustomerId()).orElse(null);
    }
}
