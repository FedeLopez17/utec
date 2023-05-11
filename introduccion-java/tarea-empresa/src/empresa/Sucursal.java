package empresa;

import java.util.LinkedList;

public class Sucursal {
    private String nombre;
    private int id;
    private String dir;
    private String tel;
    private String RUT;

    private LinkedList<Empleado> empleados = new LinkedList<>();

    public Sucursal(String nombre, int id, String dir, String tel, String RUT) {
        this.nombre = nombre;
        this.id = id;
        this.dir = dir;
        this.tel = tel;
        this.RUT = RUT;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getId() {
        return this.id;
    }

    public String getDir() {
        return this.dir;
    }

    public String getTel() {
        return this.tel;
    }

    public String getRUT() {
        return this.RUT;
    }

    public LinkedList<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }
}
