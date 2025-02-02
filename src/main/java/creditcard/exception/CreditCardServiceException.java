package creditcard.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CreditCardServiceException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({CreditCardNotValid.class})
	protected ResponseEntity<Object> handleNotValidCreditCard(CreditCardNotValid ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(ex.toString(), headers, status);
	}
	
}
