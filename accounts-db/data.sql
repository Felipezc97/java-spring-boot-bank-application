USE accounts_db;

INSERT INTO accounts (account_number, type, initial_amount, is_active, client_id) VALUES
('478758', 'SAVINGS', 2000.00, TRUE, 2),
('225487', 'CHECKING', 100.00, TRUE, 3),
('495878', 'SAVINGS', 0.00, TRUE, 4),
('496825', 'SAVINGS', 540.00, TRUE, 3),
('496890', 'SAVINGS', 300.00, TRUE, 1),
('225435', 'CHECKING', 375.00, TRUE, 1),
('225483', 'CHECKING', 1000.00, FALSE, 1);

INSERT INTO transactions (tran_date, type, amount, balance, account_id) VALUES
('2025-04-10 10:30:00', 'WITHDRAWAL', 500.00, 1500.00, 1),
('2025-04-11 17:45:00', 'DEPOSIT', 120.00, 495.00, 6);