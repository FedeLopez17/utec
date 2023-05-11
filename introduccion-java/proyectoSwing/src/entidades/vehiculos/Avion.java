package entidades.vehiculos;

public class Avion extends Vehiculo{
    double longitud;
    int cantPasajeros;

    public Avion(int id, String color, double longitud, int cantPasajeros) {
        super(id, color);
        this.longitud = longitud;
        this.cantPasajeros = cantPasajeros;
    }

    public double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantPasajeros() {
        return this.cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public String toString(){
        String descripcion = "Avion " + color.toLowerCase() + " de " + longitud + " metros y capacidad hasta " + cantPasajeros + " pasajeros.";
        return descripcion;
    }

    @Override
    public Vehiculo clonar(){
        return new Avion(this.id, this.color, this.longitud, this.cantPasajeros);
    }
}
