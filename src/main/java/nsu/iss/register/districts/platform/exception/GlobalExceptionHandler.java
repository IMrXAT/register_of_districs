package nsu.iss.register.districts.platform.exception;

import nsu.iss.register.districts.core.districts.exception.DistrictNotFoundException;
import nsu.iss.register.districts.core.farmers.exception.FarmerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DistrictNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleDistrictNotFoundException(DistrictNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }


    @ExceptionHandler(FarmerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleFarmerNotFoundException(FarmerNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }

}
