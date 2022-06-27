package ee.parking.parkingbillingapp.customer.api;

import ee.parking.parkingbillingapp.customer.model.Customer;
import ee.parking.parkingbillingapp.customer.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        List<Customer> listCustomer = new ArrayList<>();
        customerRepository.findAll().forEach(listCustomer::add);
        return listCustomer;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
