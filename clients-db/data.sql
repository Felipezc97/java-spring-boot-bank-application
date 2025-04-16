USE clients_db;

INSERT INTO clients (name, dni, gender, age, address, phone, password, is_active) VALUES
('Felipe Zumarraga', '1004083760', 'Masculino', 27, 'Amazonas y Alejandro Andrade', '0960156769', 'Clave9876', TRUE),
('Jose Lema', '1757489034', 'Masculino', 57, 'Otavalo S/N y Esmeraldas', '0982547805', 'Clave1234', TRUE),
('Marianela Montalvo', '1790836287', 'Femenino', 38, 'Amazonas y Naciones Unidas', '0982547805', 'Clave5678', TRUE),
('Juan Osorio', '1719028313', 'Masculino', 42, '13 de Junio y Equinoccial', '0982547805', 'Clave9876', FALSE);