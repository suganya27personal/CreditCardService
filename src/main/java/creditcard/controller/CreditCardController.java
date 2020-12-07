package creditcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import creditcard.app.CreditCardServiceApplication;
import creditcard.service.CreditCardService;
import creditcard.service.entity.CreditCard;
/**
 * Controller for both the 
 * services
 * @author Suganya.Prasad
 *
 */

@CrossOrigin("*")
@RestController
public class CreditCardController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CreditCardServiceApplication.class);
	
	@Autowired
	private CreditCardService creditCardService;
	
	@RequestMapping(path = "/v1/creditcard",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CreditCard> listCreditCards() {	
		return creditCardService.listAllCreditCards();
	}
	
	
	@PostMapping(path = "/v1/creditcard",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addCreditCard(@Valid  @RequestBody CreditCard creditCard,BindingResult be) throws Exception {	
		if(be.hasErrors()) {
			LOGGER.error("Validation errors");
			throw new Exception("true");
		}else {
			return creditCardService.addCreditCard(creditCard);
		}
	}
	

}
