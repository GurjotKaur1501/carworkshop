package se.yrgo.carworkshop.dto;

import java.util.List;

public class CustomerDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private List<VehicleDto> vehicles;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String phoneNumber, List<VehicleDto> vehicles) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }
}
