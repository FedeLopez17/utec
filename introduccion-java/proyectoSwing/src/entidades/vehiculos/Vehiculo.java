package entidades.vehiculos;

public abstract class Vehiculo {
    int id;
    String color;

    public Vehiculo(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract Vehiculo clonar();
}
