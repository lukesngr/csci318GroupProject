package csci318.parta.controller;

import csci318.parta.model.Contact;
import csci318.parta.repository.CustomerRepository;
import csci318.parta.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        customerToUpdate.setCompanyName(customer.getCompanyName());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setCountry(customer.getCountry());
        return customerRepository.save(customerToUpdate);
    }

    @PostMapping("/customer")
    Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

}
