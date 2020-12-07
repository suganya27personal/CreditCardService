package credicard.validation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import creditcard.app.CreditCardServiceApplication;
import creditcard.exception.CreditCardNotValid;
import creditcard.service.ValidCreditCardResolver;
import creditcard.service.entity.CreditCard;

@SpringBootTest(classes=CreditCardServiceApplication.class)
@ExtendWith(ValidCreditCardResolver.class)
@DisplayName("Testing valid credit cards")
public class ValidCreditCardValidatorTest  {

	   
    @RepeatedTest(value = 1)
    @DisplayName("All cards are valid")
    @Test
    public void validateCreditCardByLuhnsAlgo(CreditCard card) throws CreditCardNotValid {      
           assertTrue(CreditCardValidatorUtil.validateCreditCardByLuhns(card.getCreditCardNumber()));
    }

}
