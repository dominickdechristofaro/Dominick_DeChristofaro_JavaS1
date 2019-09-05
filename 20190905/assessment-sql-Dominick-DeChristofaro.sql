-- 1. truncate vs. delete 
-- 2. union vs union all
-- 3. how to remove a column from existing table
-- 4. optional
-- 5. predicate
-- 6. flatmap

-- View all tables
SELECT * FROM northwind.customers;
SELECT * FROM northwind.employees;
SELECT * FROM northwind.order_details;
SELECT * FROM northwind.orders;
SELECT * FROM northwind.products;

-- Northwind: What are the categories of products in the database?
SELECT DISTINCT category FROM northwind.products;

-- Northwind: What products are made by Dell?
SELECT * FROM northwind.products WHERE product_name LIKE '%Dell%';

-- Northwind: List all the orders shipped to Pennsylvania.
SELECT * FROM northwind.orders WHERE ship_state = 'Pennsylvania';

-- Northwind: List the first name and last name of all employees with last names that start with w
SELECT first_name, last_name FROM northwind.employees WHERE last_name LIKE 'W%';

-- Northwind: List all customers from zipcodes that start with 55
SELECT * FROM northwind.customers WHERE postal_code LIKE '55%';

-- Northwind: List all customers from zipcodes that end with 0
SELECT * FROM northwind.customers WHERE postal_code LIKE '%0';

-- Northwind: List the first name, last name, and email for all customers with a .org email address
SELECT first_name, last_name, email FROM northwind.customers WHERE email LIKE '%.org';

-- Northwind: List the first name, last name, and phone number for all customers from the 202 area code
SELECT first_name, last_name, phone FROM northwind.customers WHERE phone LIKE '%202%';

-- Northwind: List the order id for each order placed by George Wilson
SELECT orders.id 
FROM northwind.orders
INNER JOIN northwind.customers ON customers.id = orders.customer_id
WHERE customers.first_name = 'George'
AND customers.last_name = 'Wilson';

-- Northwind: List all the products and quantities associated with order 4003
SELECT products.product_name, order_details.quantity
FROM northwind.products
INNER JOIN northwind.order_details ON order_details.product_id = products.id
WHERE order_details.order_id = 4001;

-- Delete old car entries
SET sql_safe_updates = 0;
DELETE FROM car_lot.car;

/*
Add the following cars to inventory:
2012 Red Honda Accord
2017 Black Chevy Impala
2019 Siver Ford F-150
2020 White Subaru Outback
2015 Silver Ford Mustang
2018 Blue Honda Ridgeline
2017 Gray Chevy Silverado
*/

INSERT INTO car_lot.car(id, make, model, model_year, color)
VALUES 	(1, 'Honda', 'Accord', '2012', 'Red'),
		(2, 'Chevy', 'Impala', '2017', 'Black'),
        (3, 'Ford', 'F-150', '2019', 'Silver'),
        (4, 'Subaru', 'Outback', '2020', 'White'),
        (5, 'Ford', 'Mustang', '2015', 'Silver'),
        (6, 'Honda', 'Ridgeline', '2018', 'Blue'),
        (7, 'Chevy', 'Silverado', '2017', 'Gray');

-- Change all Hondas to Black
UPDATE car_lot.car
SET car.color = 'Black'
WHERE car.model = 'Honda';

-- Change 'Chevy' to 'Chevrolet'
UPDATE car_lot.car
SET car.model = 'Chevrolet'
WHERE car.model = 'Chevy';

-- Change all 2020 model years to 2019
UPDATE car_lot.car
SET car.model_year = '2019'
WHERE car.model_year = '2020';

-- Delete all blue inventory
DELETE
FROM car_lot.car
WHERE car.color = 'Blue';

-- Delete all Fords
DELETE
FROM car_lot.car
WHERE car.make = 'Ford';

-- Delete all cars from 2012 and 2017
DELETE
FROM car_lot.car
WHERE car.model_year = '2012'
AND car.model_year = '2017';

SET sql_safe_updates = 1;