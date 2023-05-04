package Excepciones;

public class CantidadDePatasException extends Exception {
    public CantidadDePatasException() {
        super("Cantidad inválida. La cantidad de patas debe ser 2 o 4.");
    }
}
