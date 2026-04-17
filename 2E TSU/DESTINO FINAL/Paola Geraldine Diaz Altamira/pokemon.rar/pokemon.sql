CREATE DATABASE pokemon_game;
USE pokemon_game;

CREATE TABLE pokemones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    tipo VARCHAR(50)
);

CREATE TABLE mochila (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    cantidad INT
);

INSERT INTO pokemones (nombre, tipo) VALUES ('Pikachu', 'Electrico');
INSERT INTO mochila (nombre, cantidad) VALUES ('Pocion', 7);