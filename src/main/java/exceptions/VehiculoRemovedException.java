package exceptions;

public class VehiculoRemovedException extends RuntimeException{

    public VehiculoRemovedException(String message){
        super(message);
    }
}