package empresa;

public class Principal {
    public static void main(String[] args) {

        Sucursal sucursal1 = new Sucursal("Casa Central", 1, "Montevideo", "28082888", "259142368838");
        Sucursal sucursal2 = new Sucursal("Sucursal Durazno", 3, "Durazno", "25823698", "248648282536");

        EmpJornalero jornalero1 = new EmpJornalero(
                "Juan",
                "Zabala",
                328672,
                68,
                "Durazno",
                "26223858",
                215.5,
                120
        );

        EmpJornalero jornalero2 = new EmpJornalero(
                "Pedro",
                "Rosen",
                669825,
                30,
                "Montevideo",
                "2852639",
                280,
                100.5
        );

        EmpMensual mensual1 = new EmpMensual(
                "Romina",
                "Paito",
                333458,
                50,
                "Durazno",
                "2528655",
                38000,
                "Comercial"
        );

        EmpMensual mensual2 = new EmpMensual(
                "Lucas",
                "Manzi",
                225698,
                45,
                "Montevideo",
                "2887469",
                38500,
                "Comercial"
        );

        sucursal1.getEmpleados().add(jornalero2);
        sucursal1.getEmpleados().add(mensual2);

        sucursal2.getEmpleados().add(jornalero1);
        sucursal2.getEmpleados().add(mensual1);

        Sucursal[] sucursales = {sucursal1, sucursal2};

        for(int indiceSucursal = 0; indiceSucursal < sucursales.length; indiceSucursal++){
            Sucursal sucursal = sucursales[indiceSucursal];

            double gastosSueldos = 0;
            for(Empleado empleado : sucursal.getEmpleados()){
                gastosSueldos += empleado.getSueldo();
            }

            System.out.println(String.format("Gastos por conceptos de sueldo sucursal %d: %.2f", indiceSucursal + 1, gastosSueldos));
        }

    }
}
