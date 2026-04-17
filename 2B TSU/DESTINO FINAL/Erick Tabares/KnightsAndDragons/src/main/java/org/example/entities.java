package org.example;

public class entities
{

    public int id;
    public String nombre;
    public String elemento;
    public int vida;
    public int daño;

    public entities(String nombre, String elemento, int vida, int daño) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.vida = vida;
        this.daño = daño;
    }

}
