package nsu.isis.register_of_districts.core.districts.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class DistrictNotFoundException extends RuntimeException{

    public DistrictNotFoundException(String message) {
        super(message);

    }

}
