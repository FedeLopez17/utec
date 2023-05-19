package datos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import entidades.personas.ListaUsuarios;
import entidades.personas.Persona;
import entidades.vehiculos.*;

public class LectorCSV {
    public ListaUsuarios leerUsuariosDesdeArchivo(String ruta) {
        ListaUsuarios usuarios = new ListaUsuarios();

        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 8) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String departamento = datos[3];
                    int cantidadHijos = Integer.parseInt(datos[4]);
                    int dia = Integer.parseInt(datos[5]);
                    int mes = Integer.parseInt(datos[6]);
                    int anio = Integer.parseInt(datos[7]);

                    ListaVehiculos vehiculos = datos.length > 8 ? obtenerVehiculos(datos) : new ListaVehiculos();

                    Persona usuario = new Persona(id, nombre, apellido, departamento, cantidadHijos, LocalDate.of(anio, mes, dia), vehiculos);
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    private ListaVehiculos obtenerVehiculos(String[] datos){
        ListaVehiculos vehiculos = new ListaVehiculos();

        for(int i = 8; i < datos.length; i++){

            switch (datos[i]){
                case "AUTO":
                    int idAuto = Integer.parseInt(datos[i + 1]);
                    String colorAuto = datos[i + 2];
                    String marcaAuto = datos[i + 3];
                    byte numPuertas = Byte.parseByte(datos[i + 4]);
                    String transmicion = datos[i + 5];
                    Auto auto = new Auto(idAuto, colorAuto, marcaAuto, numPuertas, transmicion);
                    vehiculos.add(auto);

                    i = i + 5;
                    break;

                case "MOTO":
                    int id = Integer.parseInt(datos[i + 1]);
                    String colorMoto = datos[i + 2];
                    String marcaMoto = datos[i + 3];
                    String cilindrada = datos[i + 4];
                    String tipo = datos[i + 5];
                    Moto moto = new Moto(id, colorMoto, marcaMoto, cilindrada, tipo);
                    vehiculos.add(moto);

                    i = i + 5;
                    break;

                case "AVION":
                    int idAvion = Integer.parseInt(datos[i + 1]);
                    String colorAvion = datos[i + 2];
                    double longitud = Double.parseDouble(datos[i + 3]);
                    int cantidadPersonas = Integer.parseInt(datos[i + 4]);
                    Avion avion = new Avion(idAvion, colorAvion, longitud, cantidadPersonas);
                    vehiculos.add(avion);

                    i = i + 4;
                    break;

                case "BARCO":
                    int idBarco = Integer.parseInt(datos[i + 1]);
                    String colorBarco = datos[i + 2];
                    String nombre = datos[i + 3];
                    double eslora = Double.parseDouble(datos[i + 4]);
                    double manga = Double.parseDouble(datos[i + 5]);
                    Barco barco = new Barco(idBarco,colorBarco, nombre, eslora,manga);
                    vehiculos.add(barco);

                    i = i + 5;
                    break;
            }
        }

        return vehiculos;
    }
}
