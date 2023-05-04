package Excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;

//Consigna:
//    Realice un proyecto que:
//        • Tenga definido un array de largo 5, de números enteros.
//        • Solicite los números por consola para inicializar el array.
//        • Intente ingresar un texto en vez de un número, observe el error.
//        • Controle el error. La idea es que la persona ingrese 5 números, si ingresa un
//          texto, se avisa que el dato no es válido, se almacena 0 en esa posición y se
//          avanza hasta completar el array. Después de ser completado el ingreso de
//          datos, se quiere un informe, que diga: cuántos datos válidos se ingresaron,
//          cuántos no válidos, y cuánto suma el contenido del array.
//        • Grabe un video, que muestre el funcionamiento del programa.
public class Proyecto2 {
    public static void main(String[] args) {
        int[] arrNumeros = new int[5];

        int suma = 0;
        int cantidadDatosValidos = 0;
        int cantidadDatosInvalidos = 0;

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < arrNumeros.length; i++){
            System.out.println("Ingrese un número entero para la posición " + i + ":");
            int num = 0;
            try{
                num = scanner.nextInt();
                cantidadDatosValidos++;
            } catch(InputMismatchException e){
                System.out.println("Dato inválido. Se almacenará 0 en ésta posición.");
                cantidadDatosInvalidos++;
                scanner.nextLine();
            }

            arrNumeros[i] = num;
            suma += num;
        }

        System.out.println("_______________________________________________________");
        System.out.println("Informe:");
        System.out.println("    Datos válidos: " + cantidadDatosValidos);
        System.out.println("    Datos inválidos: " + cantidadDatosInvalidos);
        System.out.println("    Suma total: " + suma);
        System.out.println("_______________________________________________________");

    }
}
