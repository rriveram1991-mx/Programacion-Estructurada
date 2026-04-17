DROP DATABASE IF EXISTS pokedex;
CREATE DATABASE pokedex;
USE pokedex;

-- Tabla con nombre 'pokemons'
CREATE TABLE pokemons (
    id_pokemon INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    nivel INT NOT NULL,
    ps_maximos INT NOT NULL
);

CREATE TABLE mochila (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    nombre_item VARCHAR(50) NOT NULL,
    cantidad INT NOT NULL DEFAULT 0
);

INSERT INTO mochila (nombre_item, cantidad) VALUES 
('Pocion', 10),
('Revivir', 5),
('Repelente', 3),
('Mapa', 1);