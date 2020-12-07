package credicard.validation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation Error if any contrainsts is violated
 * @author Suganya.Prasad
 *
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CreditCardValidator.class})
public @interface CreditCardValidation {
	String message() default "Credit card is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
