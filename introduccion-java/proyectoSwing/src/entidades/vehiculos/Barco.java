package entidades.vehiculos;

public class Barco extends Vehiculo {
    double eslora;
    double manga;

    String nombre;

    public Barco(int id, String color, String nombre, double eslora, double manga) {
        super(id, color);
        this.eslora = eslora;
        this.manga = manga;
        this.nombre = nombre;
    }

    public double getEslora() {
        return this.eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public double getManga() {
        return this.manga;
    }

    public void setManga(double manga) {
        this.manga = manga;
    }

    @Override
    public String toString(){
        String descripcion = nombre + ": barco " + color.toLowerCase() + " de " + eslora + " metros de eslora y " + manga + " de manga.";
        return descripcion;
    }

    @Override
    public Vehiculo clonar(){
        return new Barco(this.id, this.color, this.nombre, this.eslora, this.manga);
    }
}
