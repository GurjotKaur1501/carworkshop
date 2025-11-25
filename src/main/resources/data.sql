-- Customers
INSERT INTO customers(id, name, phone_number) VALUES (1, 'Anna Andersson', '0701111111');
INSERT INTO customers(id, name, phone_number) VALUES (2, 'Björn Berg', '0702222222');
INSERT INTO customers(id, name, phone_number) VALUES (3, 'Carina Carlsson', '0703333333');
INSERT INTO customers(id, name, phone_number) VALUES (4, 'Daniel Dahl', '0704444444');
INSERT INTO customers(id, name, phone_number) VALUES (5, 'Eva Eriksson', '0705555555');

-- Vehicles
INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (1, 'ABC123', 'Volvo', 'V70', 2008, 1);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (2, 'XYZ987', 'Saab', '9-5', 2005, 1);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (3, 'LOL420', 'Volkswagen', 'Golf', 2012, 2);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (4, 'FST321', 'BMW', '320i', 2015, 2);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (5, 'GOD777', 'Tesla', 'Model 3', 2022, 3);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (6, 'PNR555', 'Volvo', 'XC60', 2017, 3);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (7, 'MEW999', 'Toyota', 'Corolla', 2010, 4);

INSERT INTO vehicles(id, registration_number, brand, model, production_year, customer_id)
VALUES (8, 'AAA111', 'Ford', 'Focus', 2009, 5);

INSERT INTO vehicles(id, registration_number, brand, model,production_year, customer_id)
VALUES (9, 'ZXC321', 'Volvo', 'S60', 2016, NULL);
