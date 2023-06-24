package nsu.iss.register.districts.core.farmers.exception;

public class FarmerNotFoundException extends RuntimeException {
    public FarmerNotFoundException(String message){
        super(message);
    }
}
