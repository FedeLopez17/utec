package entidades.personas;

import java.util.LinkedList;

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
}
