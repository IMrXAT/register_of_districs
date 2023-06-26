package nsu.iss.register.districts.core.farmers.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FarmerNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public FarmerNotFoundException(String message){
        super();
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
