package creditcard.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditcard.service.entity.CreditCard;
import creditcard.service.entity.CreditCardRepository;
/**
 * Service layer implementation
 * @author Suganya.Prasad
 *
 */

@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	public CreditCardServiceImpl() {

	}
	@Autowired
	private CreditCardRepository creditCardRepo;

	public String addCreditCard(CreditCard card) {
		String response =null;
		if (getCreditCardById(card.getCreditCardNumber())) {
			response = ServiceErrorConstants.ALREADY_EXISTS;
		} else {
			creditCardRepo.save(card);
			response= ServiceErrorConstants.ADDED;
		}
		return response;
	}

	public List<CreditCard> listAllCreditCards() {
		Iterable<CreditCard> iterable = creditCardRepo.findAll();
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());

	}

	public boolean getCreditCardById(String creditCardId) {
		Optional<CreditCard> creditCard = creditCardRepo.findById(creditCardId);
		return creditCard.isPresent();

	}
}
