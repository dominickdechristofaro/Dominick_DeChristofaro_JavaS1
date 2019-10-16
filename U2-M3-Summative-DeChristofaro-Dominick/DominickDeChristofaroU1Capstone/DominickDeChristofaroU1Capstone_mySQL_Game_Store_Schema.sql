CREATE SCHEMA IF NOT EXISTS game_store;
USE game_store;

CREATE TABLE IF NOT EXISTS game (
    game_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    esrb_rating VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    studio VARCHAR(50) NOT NULL,
    quantity INT(11)
);

CREATE TABLE IF NOT EXISTS console (
    console_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(50) NOT NULL,
    memory_amount VARCHAR(20),
    processor VARCHAR(20),
    price DECIMAL(5, 2) NOT NULL,
    quantity INT(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_shirt (
    t_shirt_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    size VARCHAR(20) NOT NULL,
    color VARCHAR(20) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    quantity INT(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS sales_tax_rate (
    state CHAR(2) NOT NULL,
    rate DECIMAL(3,2) NOT NULL
);

CREATE UNIQUE INDEX ix_state_rate ON sales_tax_rate (state, rate);

CREATE TABLE IF NOT EXISTS processing_fee (
    product_type VARCHAR(20) NOT NULL,
    fee DECIMAL (4,2)
);

CREATE UNIQUE INDEX ix_product_type_fee ON processing_fee (product_type, fee);

CREATE TABLE IF NOT EXISTS invoice (
    invoice_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    street VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    zipcode VARCHAR(5) NOT NULL,
    item_type VARCHAR(20) NOT NULL,
    item_id INT(11) NOT NULL,
    unit_price DECIMAL(5,2) NOT NULL,
    quantity INT(11) NOT NULL,
    subtotal DECIMAL(5,2) NOT NULL,
    tax DECIMAL(5,2) NOT NULL,
    processing_fee DECIMAL (5,2) NOT NULL,
    total DECIMAL(5,2) NOT NULL
);