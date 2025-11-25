# Car Workshop (Spring Data JPA assignment)

GroupId: se.yrgo
ArtifactId: carworkshop

## Build & Run

Requirements: Java 17+, Maven

Link for clone repo:https://github.com/GurjotKaur1501/carworkshop.git

Build and run:
./run.sh
or
mvn spring-boot:run


H2 console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:carworkshopdb

## Endpoints

Create customer
POST /customers?name=Anna&phone=123456789

Get customer id by name
GET /customer-id?name=Anna

List all customers with vehicles (DTO)
GET /customers

Create vehicle
POST /vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2008

Assign vehicle to customer
POST /vehicles/{vehicleId}/assign?customerId={customerId}

List all vehicles
GET /vehicles

List vehicles by brand
GET /vehicles-by-brand?brand=Volvo

Create a customer:
curl -X POST "http://localhost:8080/customers?name=Anna&phone=123456789"

Create a vehicle:
curl -X POST "http://localhost:8080/vehicles?registrationNumber=ABC123&brand=Volvo&model=V70&productionYear=2008"


Assign vehicle id 1 to customer id 1:
curl -X POST "http://localhost:8080/vehicles/1/assign?customerId=1"

Get all customers with vehicles:
curl "http://localhost:8080/customers"

Get all vehicles:
curl "http://localhost:8080/vehicles"


Get vehicles by brand:
curl "http://localhost:8080/vehicles-by-brand?brand=Volvo"