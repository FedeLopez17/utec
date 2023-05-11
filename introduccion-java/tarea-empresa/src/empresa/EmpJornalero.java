package empresa;

public class EmpJornalero extends Empleado {

    private double valorHora;
    private double horasRealizadasMes;

    public EmpJornalero(String nombre, String apellido, int numBPS, int numFuncionario, String dir, String tel, double valorHora, double horasRealizadasMes) {
        super(nombre, apellido, numBPS, numFuncionario, dir, tel);
        this.valorHora = valorHora;
        this.horasRealizadasMes = horasRealizadasMes;
    }

    public double getValorHora() {
        return this.valorHora;
    }

    public double getHorasRealizadasMes() {
        return this.horasRealizadasMes;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setHorasRealizadasMes(double horasRealizadasMes) {
        this.horasRealizadasMes = horasRealizadasMes;
    }

    @Override
    public double getSueldo(){
        return this.valorHora * this.horasRealizadasMes;
    }
}
