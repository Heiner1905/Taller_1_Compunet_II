package exceptions;

public class VehiculoNotValidException extends RuntimeException {

    public VehiculoNotValidException (String message){
        super(message);
    }
}
