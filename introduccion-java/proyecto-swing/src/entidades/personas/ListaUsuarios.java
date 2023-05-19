package entidades.personas;

import java.util.*;

public class ListaUsuarios {
    private LinkedList<Persona> usuarios;

    public ListaUsuarios(){
        this.usuarios = new LinkedList<>();
    }

    public LinkedList<Persona> getUsuarios(){
        return this.usuarios;
    }

    public void add(Persona usuario){
        this.usuarios.add(usuario);
    }

    public Persona getUsuarioPorId(int id){
        Persona usuarioEncontrado = null;

        for (Persona usuario : this.usuarios) {
            if (usuario.getId() == id) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    public double getPromedioVehiculos(){
        double totalVehiculos = 0;

        for(Persona usuario : this.usuarios){
            totalVehiculos += usuario.getVehiculos().getCantidad();
        }

        return totalVehiculos / this.usuarios.size();
    }

    public String getDepartamentoConMasUsuarios(){
        HashMap<String, Integer> conteoDepartamentos = new HashMap<>();
        for(Persona usuario : this.usuarios){
            String departamento = usuario.getDptoResidencia();
            conteoDepartamentos.put(departamento, conteoDepartamentos.getOrDefault(departamento, 0) + 1);
        }

        List<String> departamentosConMasUsuarios = new ArrayList<>();
        int cantidadMaximaUsuarios = 0;

        for(Map.Entry<String, Integer> parHashMap : conteoDepartamentos.entrySet()){
            String departamento = parHashMap.getKey();
            int cantidadUsuariosDepartamento = parHashMap.getValue();
            if(cantidadUsuariosDepartamento > cantidadMaximaUsuarios){
                cantidadMaximaUsuarios = cantidadUsuariosDepartamento;
                departamentosConMasUsuarios.clear();
                departamentosConMasUsuarios.add(departamento);
            } else if(cantidadUsuariosDepartamento == cantidadMaximaUsuarios && cantidadMaximaUsuarios != 0){
                departamentosConMasUsuarios.add(departamento);
            }
        }

        String stringFinal = "";
        if(cantidadMaximaUsuarios == 0){
            stringFinal = "N/A";
        } else if(departamentosConMasUsuarios.size() == 1){
            stringFinal = String.format("%s (%d)", departamentosConMasUsuarios.get(0), cantidadMaximaUsuarios);
        } else {
            for(int i = 0; i < departamentosConMasUsuarios.size(); i++){
                stringFinal += i == 0 ?
                        departamentosConMasUsuarios.get(i) :
                        i == departamentosConMasUsuarios.size() - 1 ?
                                String.format(", y %s (%d)", departamentosConMasUsuarios.get(i), cantidadMaximaUsuarios) :
                                String.format(", %s", departamentosConMasUsuarios.get(i));
            }
        }

        return stringFinal;
    }
    public int getCantidad(){
        return this.usuarios.size();
    }
}
