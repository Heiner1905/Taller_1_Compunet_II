package exceptions;

public class ConductorNotValidException extends RuntimeException{
    
    public ConductorNotValidException (String message){
        super(message);
    }
}
