package empresa;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private int numBPS;
    private int numFuncionario;
    private String dir;
    private String tel;

    public Empleado(String nombre, String apellido, int numBPS, int numFuncionario, String dir, String tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numBPS = numBPS;
        this.numFuncionario = numFuncionario;
        this.dir = dir;
        this.tel = tel;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getNumBPS() {
        return this.numBPS;
    }

    public int getNumFuncionario() {
        return this.numFuncionario;
    }

    public String getDir() {
        return this.dir;
    }

    public String getTel() {
        return this.tel;
    }

    public abstract double getSueldo();

    public void setNumBPS(int numBPS) {
        this.numBPS = numBPS;
    }

    public void setNumFuncionario(int numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
