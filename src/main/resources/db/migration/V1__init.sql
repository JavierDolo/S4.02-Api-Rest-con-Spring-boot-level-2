-- V1__init.sql
CREATE TABLE IF NOT EXISTS fruits (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  quantity_kilos INT NOT NULL
);

INSERT INTO fruits (name, quantity_kilos) VALUES ('Apple', 10);
INSERT INTO fruits (name, quantity_kilos) VALUES ('Banana', 20);
INSERT INTO fruits (name, quantity_kilos) VALUES ('Orange', 15);
