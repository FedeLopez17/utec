package Excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;

//Consigna 3:
//    Realice un proyecto que:
//        • Defina una clase Mascota, con por lo menos los siguientes atributos:
//          idMascota, nombre, cantidadDePatas.
//        • Defina un array de 3 mascotas.
//        • Solicite los datos de las 3 mascotas por consola.
//        • Haga el control de excepciones para que solamente se puedan ingresar
//          mascotas con 2 o 4 patas. Si el usuario ingresa un dato no válido, el programa
//          debe permitirle ingresar nuevamente los datos de otra mascota que sea válida
//          (o sea, que quede en loop hasta que la mascota tenga todos los atributos
//          correctos).
//        • Grabe un video, que muestre el funcionamiento del programa.


public class Proyecto3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Mascota[] arrMascotas = new Mascota[3];

        for(int i = 0; i < arrMascotas.length; i++){

            int id = -1;
            boolean idValida = false;
            while(!idValida){
                try{
                    System.out.println("Ingrese el id de la mascota " + (i + 1) + ":");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    idValida = true;
                }  catch(InputMismatchException e){
                    System.out.println("ID inválido. El ID debe ser un número entero.");
                    scanner.nextLine();
                }
            }

            System.out.println("Ingrese el nombre de la mascota " + (i + 1) + ":");
            String nombre = scanner.nextLine();

            byte cantidadDePatas = -1;
            boolean cantidadDePatasValida = false;
            while(!cantidadDePatasValida){
                try{
                    System.out.println("Ingrese la cantidad de patas de la mascota " + (i + 1) + ":");
                    cantidadDePatas = scanner.nextByte();
                    scanner.nextLine();
                    if(cantidadDePatas != 2 && cantidadDePatas != 4){
                        throw new CantidadDePatasException();
                    }
                    cantidadDePatasValida = true;
                }  catch(InputMismatchException e){
                    System.out.println("Cantidad inválida.");
                    scanner.nextLine();
                } catch(CantidadDePatasException e) {
                    System.out.println(e.getMessage());
                }
            }

            arrMascotas[i] = new Mascota(id, nombre, cantidadDePatas);
            System.out.println(arrMascotas[i].nombre);
            System.out.println("¡Mascota agregada correctamente!");
            System.out.println("______________________________________________");
        }

        System.out.println();
        System.out.println("Las mascotas agregadas fueron:");
        for(int i = 0; i < arrMascotas.length; i++){
            System.out.println(arrMascotas[i]);
        }
    }
}
