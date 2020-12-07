package credicard.validation;

import java.util.Arrays;

import creditcard.exception.CreditCardNotValid;

/**
 * Responsibility of this class is to validate the creditCard Number for
 * invalid length and luhns algorithm
 * 
 * @author Suganya.Prasad
 *
 */
public class CreditCardValidatorUtil {

	/**
	 * Validates if the credit card is of valid length
	 * 
	 * @param creditCardNo
	 * @return
	 */
	public static boolean validateCreditCardLength(String creditCardNo) {
		if (creditCardNo.length() < 13 || creditCardNo.length() > 19) {
			return false;
		}
		return true;
	}
	/**
	 * Validates if the credit card adheres to Luhns algo
	 * 
	 * @param creditCardNo
	 * @return
	 */
	public static boolean validateCreditCardByLuhns(String creditCardNo) throws CreditCardNotValid {

		boolean isCreditCardLengthValid = validateCreditCardLength(creditCardNo);

		if (isCreditCardLengthValid) {
			/*
			 * Received credit card number is string. Converting to int array for
			 * computation
			 */

			int[] creditCardIntArray = new int[creditCardNo.length()];
			for (int i = 0; i < creditCardNo.length(); i++) {
				creditCardIntArray[i] = Character.getNumericValue(creditCardNo.charAt(i));
			}

			// step1 : refill the array's alternate 2nd digit with doubled values
			for (int i = creditCardIntArray.length - 1; i > 0; i--) {
					i--;
					int totalDigit = creditCardIntArray[i] * 2;
					creditCardIntArray[i] = totalDigit;
					if (totalDigit >= 10 && totalDigit <= 20) {
						String totalStr = String.valueOf(totalDigit);
						creditCardIntArray[i] = Character.getNumericValue(totalStr.charAt(0))
								+ Character.getNumericValue(totalStr.charAt(1));
					}
			}
			
			// Sum up the elements of array
			int sum = Arrays.stream(creditCardIntArray).sum();

			// check if the sum is multiple of 10;
			
			if (sum % 10 == 0) {
				return true;
			} else {
				throw new CreditCardNotValid();
			}

		}
		return false;
	}

}
