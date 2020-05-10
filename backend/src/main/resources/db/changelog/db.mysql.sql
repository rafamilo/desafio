--liquibase formatted sql

--changeset reginaldo:1587663728087-1
CREATE TABLE biddings (id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, description TEXT, type ENUM("Menor Preço", "Nota Preço") default "Menor Preço");