package es.mdfe.gestionpreguntas.validation;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ArgumentNotValidExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleValidationExceptions(
			ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getConstraintViolations().forEach((error) -> {
	        String fieldName = error.getPropertyPath().toString();
	        String errorMessage = error.getMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}	