package Practica;

public class Casino {
    private static Casino instancia;
    private  String nombre;
    private Persona responsable;

    private Casino(){

    }

    public static Casino getInstancia() {
        if(instancia == null) instancia = new Casino();

        return instancia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getResponsable() {
        return this.responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString(){
        return String.format("Casino: {nombre: %s, responsable: %s}", this.nombre, this.responsable.toString());
    }
}
