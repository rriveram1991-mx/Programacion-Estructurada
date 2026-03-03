package cuatri2.unidad3;

public class foreach {
    public static void main(String[] args) {
        String[] animales = {"Perro", "Gato", "Cabra", "Vaca", "Oveja","Caballo"};
        System.out.println("Los animales de cuatro patas son:");
        for (String animal : animales) {
            System.out.println(animal);
        }
    }
    
}
