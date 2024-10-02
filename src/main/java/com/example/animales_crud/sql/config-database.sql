CREATE DATABASE IF NOT EXISTS animales;

USE animales;

CREATE TABLE IF NOT EXISTS animales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    especie VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    peso DECIMAL(5,2) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_ingreso DATE NOT NULL
);
