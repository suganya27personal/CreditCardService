package creditcard.service;

import java.util.List;

import creditcard.service.entity.CreditCard;
/**
 * contract to define a credit card service
 * @author Suganya.Prasad
 *
 */
public interface CreditCardService {
	
	public String addCreditCard(CreditCard card);
	
	public List<CreditCard> listAllCreditCards();
	
	public boolean getCreditCardById(String creditCardId);
}
