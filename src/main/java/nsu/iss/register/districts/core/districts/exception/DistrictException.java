package nsu.iss.register.districts.core.districts.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class DistrictException {
    private final String message;
    private final HttpStatus status;
}
