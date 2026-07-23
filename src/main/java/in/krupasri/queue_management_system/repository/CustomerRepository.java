package in.krupasri.queue_management_system.repository;

import in.krupasri.queue_management_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
