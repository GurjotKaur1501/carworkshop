package se.yrgo.carworkshop.dto;

public class VehicleDto {
    private Long id;
    private String registrationNumber;
    private String brand;
    private String model;
    private Integer productionYear;
    private Long customerId;

    public VehicleDto() {
    }

    public VehicleDto(Long id, String registrationNumber, String brand, String model, Integer productionYear, Long customerId) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
