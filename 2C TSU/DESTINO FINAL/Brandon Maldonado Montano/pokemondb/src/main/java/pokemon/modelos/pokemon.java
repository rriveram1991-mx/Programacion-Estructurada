package pokemon.modelos;

public class pokemon {
    public int id;
    public String nombre;
    public String tipo;
    public int salud;
    public int ataque;

    public pokemon(String nombre, String tipo, int salud, int ataque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
    }
}