package in.krupasri.queue_management_system.service;


import in.krupasri.queue_management_system.entity.Customer;
import in.krupasri.queue_management_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
