CREATE DATABASE IF NOT EXISTS accounts_db;

USE accounts_db;

CREATE TABLE IF NOT EXISTS accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    initial_amount DECIMAL(15, 2) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    client_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    type VARCHAR(50),
    amount DECIMAL(15, 2) NOT NULL,
    balance DECIMAL(15, 2),
    account_id INT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);