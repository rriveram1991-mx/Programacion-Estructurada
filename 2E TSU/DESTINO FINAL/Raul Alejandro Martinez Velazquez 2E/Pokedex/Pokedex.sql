CREATE DATABASE pokedex;
USE pokedex;

CREATE TABLE pokemon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(30) NOT NULL
);

CREATE TABLE bag (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL
);
INSERT INTO pokemon (nombre, tipo)
VALUES ('Pikachu', 'Electrico');

INSERT INTO bag (nombre, cantidad)
VALUES ('Pocion', 5);

SELECT * FROM pokemon;
SELECT * FROM bag;