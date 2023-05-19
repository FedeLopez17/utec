import datos.LectorCSV;
import entidades.personas.ListaUsuarios;
import interfaz.MenuPrincipal;


public class Main {
    public static void main(String[] args) {
        try{
            ListaUsuarios usuarios = new LectorCSV().leerUsuariosDesdeArchivo("src/datos/datos.csv");
            new MenuPrincipal(usuarios);
        } catch (Exception e) {
            new MenuPrincipal(new ListaUsuarios());
        }
    }
}
