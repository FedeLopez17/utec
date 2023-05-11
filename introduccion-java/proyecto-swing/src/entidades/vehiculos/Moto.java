package entidades.vehiculos;

public class Moto extends Vehiculo{
    String marca;

    String cilindrada;

    String tipo;

    public Moto(int id, String color, String marca, String cilindrada, String tipo) {
        super(id, color);
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getCilindrada() {
        return this.cilindrada;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString(){
        String descripcion = "Moto " + tipo.toLowerCase() + " " + marca + " " + color.toLowerCase() + " de " + cilindrada + ".";
        return descripcion;
    }

    @Override
    public Vehiculo clonar(){
        return new Moto(this.id, this.color, this.marca, this.cilindrada, this.tipo);
    }
}
