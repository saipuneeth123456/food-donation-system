CREATE DATABASE food_donation_db;

USE food_donation_db;

CREATE TABLE food_donations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    donor_name VARCHAR(100) NOT NULL,
    donor_phone VARCHAR(15) NOT NULL,
    food_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    location VARCHAR(200) NOT NULL,
    available_until DATETIME,
    status VARCHAR(20) DEFAULT 'AVAILABLE'
);
