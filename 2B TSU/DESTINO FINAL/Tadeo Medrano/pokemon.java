package crud_2B;

public class pokemon {
    private int id;
    private String nombre, tipo;
    private int nivel, psMaximos;

    public pokemon(String nombre, String tipo, int nivel, int psMaximos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.psMaximos = psMaximos;
    }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNivel() { return nivel; }
    public int getPsMaximos() { return psMaximos; }
}