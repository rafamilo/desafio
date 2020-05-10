--liquibase formatted sql

--changeset reginaldo:1589088050671-1
CREATE TABLE biddings (id INT AUTO_INCREMENT NOT NULL, `description` TEXT NULL, type ENUM("NOTA_PRECO", "MENOR_PRECO") DEFAULT "MENOR_PRECO" NULL, CONSTRAINT PK_BIDDINGS PRIMARY KEY (id));

--changeset reginaldo:1589088050671-2
CREATE TABLE proposal (id INT AUTO_INCREMENT NOT NULL, `provider` VARCHAR(50) NULL, note DECIMAL(19,2) NULL DEFAULT 0.00, price DECIMAL(19,2) NULL DEFAULT 0.00, createdDate VARCHAR(20) NULL, classification INT(11) NULL, biddingId INT(11) NOT NULL, CONSTRAINT PK_PROPOSAL PRIMARY KEY (id));

--changeset reginaldo:1589088050671-3
ALTER TABLE proposal ADD CONSTRAINT PK_PROPOSAL_BIDDING_ID FOREIGN KEY (biddingId) REFERENCES biddings (id) ON UPDATE RESTRICT ON DELETE RESTRICT;