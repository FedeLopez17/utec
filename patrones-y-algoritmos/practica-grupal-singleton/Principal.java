package Practica;

public class Principal {
    public static void main(String[] args) {
        Casino conrad = Casino.getInstancia();
        conrad.setNombre("Conrad");
        conrad.setResponsable(new Persona("1234567-8", "Luis Suárez", StatusPersona.ACTIVO));

        System.out.println(conrad);
    }
}
