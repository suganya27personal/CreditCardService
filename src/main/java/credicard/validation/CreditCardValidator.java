package credicard.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import creditcard.app.CreditCardServiceApplication;
import creditcard.exception.CreditCardNotValid;

public class CreditCardValidator implements ConstraintValidator<CreditCardValidation,String> {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CreditCardServiceApplication.class);

	@Override
	public boolean isValid(String ccNum, ConstraintValidatorContext context) {
		boolean isValidCC =  CreditCardValidatorUtil.validateCreditCardLength(ccNum);
		if(isValidCC) {
			try {
				return CreditCardValidatorUtil.validateCreditCardByLuhns(ccNum);
			} catch (CreditCardNotValid e) {
				LOGGER.error("Credit card is not valid");
				return false;
			}
		}
		return isValidCC;
	}

}
