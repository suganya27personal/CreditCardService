package creditcard.service;

import java.util.Random;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import creditcard.service.entity.CreditCard;

public class ValidCreditCardResolver implements ParameterResolver {
	
	public static CreditCard[] VALID_CARDS = {
		      new CreditCard("John","10","1000","4111111111111111"),
		      new CreditCard("John","10","1000","340000000000009"),
		      new CreditCard("John","10","1000","5500000000000004"),
		      new CreditCard("John","10","1000","6011000000000004"),
		      new CreditCard("John","10","1000","3088000000000009"),
		      new CreditCard("John","10","1000","201400000000009"),
		      new CreditCard("John","10","1000","5500000000000004")
		      
		  };

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		    boolean val = false;
		    if (parameterContext.getParameter().getType() == CreditCard.class) {
		        val = true;
		    }
		    return val;
		
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		 Object val = null;
		    if (parameterContext.getParameter().getType() == CreditCard.class) {
		    	val = VALID_CARDS[new Random().nextInt(VALID_CARDS.length)];
		    }
		    return val;
	}

}
