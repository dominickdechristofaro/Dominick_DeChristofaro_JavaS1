CREATE SCHEMA IF NOT EXISTS book_store;
USE book_store;

CREATE TABLE IF NOT EXISTS book (
	book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(15) NOT NULL,
    publish_date DATE NOT NULL,
    author_id INT NOT NULL,
    title VARCHAR(70) NOT NULL,
    publisher_id INT NOT NULL,
    price DECIMAL(5,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
	author_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    postal_code VARCHAR(25) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS publisher (
	publisher_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state CHAR(2) NOT NULL,
    postal_code VARCHAR(25) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(60) NOT NULL
);

/* Foreign Keys: book */
ALTER TABLE book ADD CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES author(author_id);
ALTER TABLE book ADD CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(publisher_id);