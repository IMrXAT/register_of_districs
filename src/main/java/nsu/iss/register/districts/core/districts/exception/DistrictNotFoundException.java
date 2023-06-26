package nsu.iss.register.districts.core.districts.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class DistrictNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public DistrictNotFoundException(String message) {
        super();
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }

}
