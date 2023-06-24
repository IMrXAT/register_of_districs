package nsu.iss.register.districts.core.farmers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FarmerExceptionHandler {
    @ExceptionHandler(value = {FarmerNotFoundException.class})
    public ResponseEntity<Object> handleFarmerNotFoundException(FarmerNotFoundException exception){
        FarmerException districtException = new FarmerException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(districtException, HttpStatus.NOT_FOUND);
    }
}
