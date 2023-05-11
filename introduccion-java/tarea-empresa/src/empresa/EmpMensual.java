package empresa;

public class EmpMensual extends Empleado{

    private double salarioMensual;
    private String tipoDeRegimen;

    public EmpMensual(String nombre, String apellido, int numBPS, int numFuncionario, String dir, String tel, double salarioMensual, String tipoDeRegimen){
        super(nombre, apellido, numBPS, numFuncionario, dir, tel);
        this.salarioMensual = salarioMensual;
        this.tipoDeRegimen = tipoDeRegimen;
    }

    public String getTipoDeRegimen() {
        return this.tipoDeRegimen;
    }

    public void setTipoDeRegimen(String tipoDeRegimen) {
        this.tipoDeRegimen = tipoDeRegimen;
    }

    @Override
    public double getSueldo(){
        return this.salarioMensual;
    }
}
