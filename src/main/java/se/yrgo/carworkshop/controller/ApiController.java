package se.yrgo.carworkshop.controller;

import org.springframework.web.bind.annotation.*;
import se.yrgo.carworkshop.model.Customer;
import se.yrgo.carworkshop.model.Vehicle;
import se.yrgo.carworkshop.repository.CustomerRepository;
import se.yrgo.carworkshop.repository.VehicleRepository;
import se.yrgo.carworkshop.dto.CustomerDto;
import se.yrgo.carworkshop.dto.VehicleDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;

    public ApiController(CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping("/customers")
    public ResponseEntity<Long> createCustomer(@RequestParam String name, @RequestParam String phone) {
        Customer c = new Customer();
        c.setName(name);
        c.setPhoneNumber(phone);
        Customer saved = customerRepository.save(c);
        return ResponseEntity.ok(saved.getId());
    }

    @GetMapping("/customer-id")
    public ResponseEntity<Long> getCustomerIdByName(@RequestParam String name) {
        return customerRepository.findByName(name)
                .map(c -> ResponseEntity.ok(c.getId()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomersWithVehicles() {
        List<Customer> customers = customerRepository.findAllWithVehicles();
        return customers.stream().map(this::toCustomerDto).collect(Collectors.toList());
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Long> createVehicle(@RequestParam String registrationNumber,
                                              @RequestParam String brand,
                                              @RequestParam String model,
                                              @RequestParam Integer productionYear) {
        Vehicle v = new Vehicle();
        v.setRegistrationNumber(registrationNumber);
        v.setBrand(brand);
        v.setModel(model);
        v.setProductionYear(productionYear);
        Vehicle saved = vehicleRepository.save(v);
        return ResponseEntity.ok(saved.getId());
    }

    @PostMapping("/vehicles/{vehicleId}/assign")
    public ResponseEntity<String> assignVehicleToCustomer(@PathVariable Long vehicleId, @RequestParam Long customerId) {
        return vehicleRepository.findById(vehicleId).map(v -> {
            Customer c = customerRepository.findById(customerId).orElse(null);
            if (c == null) {
                return ResponseEntity.badRequest().body("Customer not found");
            }
            if (v.getCustomer() != null) {
                v.getCustomer().removeVehicle(v);
            }
            c.addVehicle(v);
            vehicleRepository.save(v);
            customerRepository.save(c);
            return ResponseEntity.ok("Assigned");
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vehicles")
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(this::toVehicleDto).collect(Collectors.toList());
    }

    @GetMapping("/vehicles-by-brand")
    public List<VehicleDto> getVehiclesByBrand(@RequestParam String brand) {
        return vehicleRepository.findVehiclesByBrandUsingQuery(brand).stream().map(this::toVehicleDto).collect(Collectors.toList());
    }

    private CustomerDto toCustomerDto(Customer c) {
        List<VehicleDto> vehicles = c.getVehicles().stream()
                .map(this::toVehicleDto)
                .collect(Collectors.toList());
        return new CustomerDto(c.getId(), c.getName(), c.getPhoneNumber(), vehicles);
    }

    private VehicleDto toVehicleDto(Vehicle v) {
        Long customerId = v.getCustomer() != null ? v.getCustomer().getId() : null;
        return new VehicleDto(v.getId(), v.getRegistrationNumber(), v.getBrand(), v.getModel(), v.getProductionYear(), customerId);
    }
}
