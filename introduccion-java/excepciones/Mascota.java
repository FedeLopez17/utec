package Excepciones;

public class Mascota {
    int idMascota;
    String nombre;
    byte cantidadDePatas;

    public Mascota(int idMascota, String nombre, byte cantidadDePatas) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.cantidadDePatas = cantidadDePatas;
    }

    @Override
    public String toString() {
        return "________________________\nID: " + this.idMascota + "\nNombre: " + this.nombre +
                "\nCantidad de patas: " + cantidadDePatas + "\n________________________\n";
    }
}
