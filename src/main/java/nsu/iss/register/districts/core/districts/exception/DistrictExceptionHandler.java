package nsu.iss.register.districts.core.districts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DistrictExceptionHandler {

    @ExceptionHandler(value = {DistrictNotFoundException.class})
    public ResponseEntity<Object> handleDistrictNotFoundException(DistrictNotFoundException exception){
        DistrictException districtException = new DistrictException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(districtException, HttpStatus.NOT_FOUND);
    }

}
