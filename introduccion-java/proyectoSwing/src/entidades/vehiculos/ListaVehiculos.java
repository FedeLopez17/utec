package entidades.vehiculos;

import java.util.LinkedList;

public class ListaVehiculos {
    private LinkedList<Vehiculo> vehiculos;

    public ListaVehiculos(){
        vehiculos = new LinkedList<>();
    }

    public void add(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public int getCantidad(){
        return this.vehiculos.size();
    }

    public String[] getDescripciones(){
        String[] descripciones = new String[vehiculos.size()];

        for(int i = 0; i < descripciones.length; i++){
            descripciones[i] = vehiculos.get(i).toString();
        }

        return descripciones;
    }

    public ListaVehiculos getAutos(){
        return getVehiculo(Auto.class);
    }

    public ListaVehiculos getMotos(){
        return getVehiculo(Moto.class);
    }

    public ListaVehiculos getAviones(){
        return getVehiculo(Avion.class);
    }

    public ListaVehiculos getBarcos(){
        return getVehiculo(Barco.class);
    }

    private ListaVehiculos getVehiculo(Class<? extends Vehiculo> tipoDeVehiculo){
        ListaVehiculos vehiculos = new ListaVehiculos();

        for(Vehiculo vehiculo : this.vehiculos){
            if(tipoDeVehiculo.isInstance(vehiculo)){
                vehiculos.add(vehiculo);
            }
        }

        return vehiculos;
    }

    public void vaciar(){
        this.vehiculos.clear();
    }


    public ListaVehiculos clonar(){
        ListaVehiculos copiaVehiculos = new ListaVehiculos();

        for(Vehiculo vehiculo : this.vehiculos){
            copiaVehiculos.add(vehiculo.clonar());
        }

        return copiaVehiculos;
    }

    public Vehiculo getVehiculoPorId(int id){
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo vehiculo : this.vehiculos) {
            if (vehiculo.getId() == id) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }
}
