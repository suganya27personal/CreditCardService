package creditcard.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * To bind the errors returned by validation framework
 * @author Suganya.Prasad
 *
 */
@ControllerAdvice
public class CreditCardExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		Map<String, Object> errorsMap = new LinkedHashMap<>();
		errorsMap.put("errors", errors);
		return new ResponseEntity<>(errors, headers, status);
	}
	
	

}
