package nsu.iss.register.districts.core.farmers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class FarmerException {

        private final String message;
        private final HttpStatus status;
}
