package transport.mangement.system.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ErrorHandlingController {
	
	@ExceptionHandler(Exception.class) 
	 public ResponseEntity<ExceptionResponse>specialException(Exception e) throws Exception {
	  
	  ExceptionResponse eR = new ExceptionResponse(); 
	  eR.setCode(HttpStatus.BAD_REQUEST.value());
	  eR.setErrorCode("INVALID_DETAILS");

	  return new ResponseEntity<ExceptionResponse>(eR,HttpStatus.BAD_REQUEST);
	 }
 
 @ExceptionHandler(CustomException.class) 
 public ResponseEntity<ExceptionResponse>specialException(CustomException e) throws Exception {
  
  ExceptionResponse eR = new ExceptionResponse(); 
  eR.setCode(HttpStatus.BAD_REQUEST.value());
  eR.setErrorCode(e.getMessage());

  return new ResponseEntity<ExceptionResponse>(eR,HttpStatus.BAD_REQUEST);
 }
  
}
