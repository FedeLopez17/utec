package entidades.vehiculos;

public class Auto extends Vehiculo{

    String marca;
    byte cantPuertas;

    String transmicion;

    public Auto(int id, String color, String marca, byte cantPuertas, String transmicion) {
        super(id, color);
        this.marca = marca;
        this.cantPuertas = cantPuertas;
        this.transmicion = transmicion;
    }

    public String getMarca(){
        return this.marca;
    }

    public int getCantPuertas() {
        return this.cantPuertas;
    }

    public void setCantPuertas(byte cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    public String getTransmicion() {
        return this.transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    @Override
    public String toString(){
        String descripcion = "Auto " + this.marca + " " + this.color.toLowerCase() + " de " + this.cantPuertas + " puertas y transmición " + this.transmicion.toLowerCase() + ".";
        return descripcion;
    }

    @Override
    public Vehiculo clonar(){
        return new Auto(this.id, this.color, this.marca, this.cantPuertas, this.transmicion);
    }
}
