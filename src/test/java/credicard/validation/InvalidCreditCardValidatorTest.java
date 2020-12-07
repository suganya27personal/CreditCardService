package credicard.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import creditcard.app.CreditCardServiceApplication;
import creditcard.exception.CreditCardNotValid;
import creditcard.service.InValidCreditCardResolver;
import creditcard.service.ValidCreditCardResolver;
import creditcard.service.entity.CreditCard;

@SpringBootTest(classes=CreditCardServiceApplication.class)
@ExtendWith(InValidCreditCardResolver.class)
@DisplayName("Testing for Invalid cards")
public class InvalidCreditCardValidatorTest  {

	   
    @RepeatedTest(value = 2)
    @DisplayName("All cards are invalid")
    @Test
    public void validateCreditCardByLuhnsAlgo(CreditCard card) throws CreditCardNotValid {    
           assertFalse(CreditCardValidatorUtil.validateCreditCardByLuhns(card.getCreditCardNumber()));
    }

}
