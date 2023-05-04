package Excepciones;
import java.util.Scanner;

//Consigna:
//  Realice un proyecto que:
//      • Tenga definido un array de largo 5, y contenga nombres de personas.
//      • Muestre en consola, que se puede acceder a cada una de las posiciones del
//        array y funciona correctamente.
//      • Muestre en consola, que intenta acceder a una posición no válida del array.
//      • A partir del error cometido en el punto anterior, haga el control de excepción
//        que indique la no validez de la instrucción que se quiere realizar.
//      • Grabe un video, que muestre que se puede acceder a las posiciones válidas y
//        se controló el acceso a una posición no válida.
public class Proyecto1 {
    public static void main(String[] args) {
        String[] arrNombres = {"Luis", "Edinson", "Giorgian", "Rodrigo", "Federico"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique a que posición del array quiere acceder:");
        int indice = scanner.nextInt();

        try {
            System.out.println("El nombre en la posición " + indice + " es: " + arrNombres[indice] + ".");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Posición seleccionada fuera de los límites del Array. La posición debe ser un numero entero entre 0 y " + (arrNombres.length - 1) + ".");
        }

    }
}
