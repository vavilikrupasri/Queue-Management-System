package in.krupasri.queue_management_system.controller;


import in.krupasri.queue_management_system.dto.CustomerRequestDto;
import in.krupasri.queue_management_system.entity.Customer;
import in.krupasri.queue_management_system.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {
    @Autowired
        private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();

        customer.setName(customerRequestDto.getName());
        customer.setPhoneNumber(customerRequestDto.getPhoneNumber());

        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    }

