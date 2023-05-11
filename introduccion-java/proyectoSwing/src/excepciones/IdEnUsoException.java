package excepciones;

public class IdEnUsoException extends Exception{
    public IdEnUsoException(){
        super("ID ya en uso!");
    }
}
