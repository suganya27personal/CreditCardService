package creditcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import creditcard.app.CreditCardServiceApplication;
import creditcard.service.entity.CreditCard;
import creditcard.service.entity.CreditCardRepository;

@SpringBootTest(classes = CreditCardServiceApplication.class)
@ExtendWith(CreditCardParameterResolver.class)
public class CreditCardServiceTest {

	public CreditCardServiceTest() {}

	@Autowired
	CreditCardService creditCardService;

	@DisplayName("Test add service")
	@Test
	public void testAddCreditCard(CreditCard card) {
		card = new CreditCard("Jane Doe", "10", "2000", "4111111111111111");
		String cardAdded = creditCardService.addCreditCard(card);
		assertEquals(cardAdded, "credit card added successfully");

	}

	@DisplayName("Test get service")
	@Test
	public void testListAllCreditCards() {
		CreditCard card = new CreditCard("Jane Doe", "10", "2000", "340000000000009");
		creditCardService.addCreditCard(card);
		List<CreditCard> cards = creditCardService.listAllCreditCards();
		assertEquals(1, cards.size());
	}

	@Test
	@DisplayName("Test get credit card by id")
	public void testGetCreditCardById() {
		CreditCard card = new CreditCard("Jane Doe", "10", "2000", "340000000000009");
		creditCardService.addCreditCard(card);
		boolean isAlreadyAdded = creditCardService.getCreditCardById(card.getCreditCardNumber());
		assertEquals(isAlreadyAdded, true);
	}

}
