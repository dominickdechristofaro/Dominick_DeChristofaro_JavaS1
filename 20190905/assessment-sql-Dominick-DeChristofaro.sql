/*
car_lot

Add the following cars to inventory:
2012 Red Honda Accord
2017 Black Chevy Impala
2019 Siver Ford F-150
2020 White Subaru Outback
2015 Silver Ford Mustang
2018 Blue Honda Ridgeline
2017 Gray Chevy Silverado
Make the following updates to the database:
Change all Hondas to Black
Change 'Chevy' to 'Chevrolet'
Change all 2020 model years to 2019
Delete the following:
Delete all blue inventory
Delete all Fords
Delete all cars from 2012 and 2017
*/

-- Northwind: What are the categories of products in the database?
SELECT DISTINCT category FROM northwind.products;

-- Northwind: What products are made by Dell?
SELECT * FROM northwind.products WHERE product_name LIKE '%Dell%';

-- Northwind: List all the orders shipped to Pennsylvania.

-- Northwind: List the first name and last name of all employees with last names that start with w

-- Northwind: List all customers from zipcodes that start with 55

-- Northwind: List all customers from zipcodes that end with 0

-- Northwind: List the first name, last name, and email for all customers with a .org email address

-- Northwind: List the first name, last name, and phone number for all customers from the 202 area code

-- Northwind: List the order id for each order placed by George Wilson

-- Northwind: List all the products and quantities associated with order 4003

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

/*
Make the following updates to the database:
Change all Hondas to Black
Change 'Chevy' to 'Chevrolet'
Change all 2020 model years to 2019
*/

/*
Delete the following:
Delete all blue inventory
Delete all Fords
Delete all cars from 2012 and 2017
*/