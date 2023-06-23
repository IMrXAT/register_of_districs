package nsu.iss.register.districts.core.districts.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DistrictNotFoundException extends RuntimeException{

    public DistrictNotFoundException(String message) {
        super(message);

    }

}
