package Practica;

public class Persona {
    private String cedula;
    private String nombre;
    private StatusPersona status;

    Persona(String cedula, String nombre, StatusPersona status){
        this.cedula = cedula;
        this.nombre = nombre;
        this.status = status;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public StatusPersona getStatus() {
        return this.status;
    }

    public void setStatus(StatusPersona status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return String.format(
                "Persona:  {cedula: %s, nombre: %s, status: %s}",
                this.cedula, this.nombre, this.status.name()
        );
    }
}
