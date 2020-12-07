package creditcard.service;

import java.util.Random;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import creditcard.service.entity.CreditCard;

public class InValidCreditCardResolver implements ParameterResolver {
	
	public static CreditCard[] INVALID_CARDS = {
		      new CreditCard("John","10","1000","4111111111110111"),
		      new CreditCard("John","10","1000","1000290000"),
		      new CreditCard("John","10","1000","1000000000007788")
		      
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
		    	val = INVALID_CARDS[new Random().nextInt(INVALID_CARDS.length)];
		    }
		    return val;
	}

}
