package exceptions;

public class ConductorNotFoundException extends RuntimeException {
    public ConductorNotFoundException(String message){
        super(message);
    }
}
