package entidades.personas;
import entidades.vehiculos.ListaVehiculos;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String dptoResidencia;
    private int cantidadHijos;
    private LocalDate fechaNacimiento;
    private ListaVehiculos vehiculos;

    public Persona(int id, String nombre, String apellido, String dptoResidencia, int cantidadHijos, LocalDate fechaNacimiento, ListaVehiculos vehiculos){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dptoResidencia = dptoResidencia;
        this.cantidadHijos = cantidadHijos;
        this.fechaNacimiento = fechaNacimiento;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDptoResidencia() {
        return dptoResidencia;
    }

    public void setDptoResidencia(String dptoResidencia) {
        this.dptoResidencia = dptoResidencia;
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ListaVehiculos getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(ListaVehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "___________________________"
                + "\nID: " + this.id
                + "\nNombre: " + this.nombre
                + "\nApellido: " + this.apellido
                + "\nDepartamento de residencia: " + this.dptoResidencia
                + "\nCantidad de hijos: " + this.cantidadHijos
                + "\nFecha de nacimiento: " + this.fechaNacimiento
                + "\nAutos: " + this.vehiculos.getAutos().getCantidad()
                + "\nMotos: " + this.vehiculos.getMotos().getCantidad()
                + "\nAviones: " + this.vehiculos.getAviones().getCantidad()
                + "\nBarcos: " + this.vehiculos.getBarcos().getCantidad()
                + "\n___________________________";
    }
}
