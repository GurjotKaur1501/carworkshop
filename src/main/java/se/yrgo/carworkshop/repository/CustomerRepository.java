package se.yrgo.carworkshop.repository;

import se.yrgo.carworkshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
    @Query("SELECT DISTINCT c FROM Customer c LEFT JOIN FETCH c.vehicles")
    List<Customer> findAllWithVehicles();
}
