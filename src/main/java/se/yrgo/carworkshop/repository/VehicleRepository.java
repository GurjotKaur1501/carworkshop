package se.yrgo.carworkshop.repository;

import se.yrgo.carworkshop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByCustomerId(Long customerId);
    List<Vehicle> findByBrand(String brand);
    @Query("SELECT v FROM Vehicle v WHERE v.brand = ?1")
    List<Vehicle> findVehiclesByBrandUsingQuery(String brand);
}
