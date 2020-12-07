package creditcard.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import creditcard.service.entity.CreditCard;

public class CreditCardParameterResolver implements ParameterResolver {
	  @Override
	  public boolean supportsParameter(ParameterContext parameterContext, 
	    ExtensionContext extensionContext) throws ParameterResolutionException {
	      return parameterContext.getParameter().getType() == CreditCard.class;
	  }

	  @Override
	  public Object resolveParameter(ParameterContext parameterContext, 
	    ExtensionContext extensionContext) throws ParameterResolutionException {
	      return new CreditCard();
	  }
	}
