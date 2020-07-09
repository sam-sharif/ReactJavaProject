package telus.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
    public ResponseEntity<?> handleException(ProjectIdException exc){
		
		ExceptionErrorResponse error = new ExceptionErrorResponse(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
    public ResponseEntity<?> handleException(Exception exc){
		
		ExceptionErrorResponse error = new ExceptionErrorResponse(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
