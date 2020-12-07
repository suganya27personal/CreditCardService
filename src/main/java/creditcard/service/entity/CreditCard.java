package creditcard.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import credicard.validation.CreditCardValidation;

/**
 * 
 * @author Suganya.Prasad
 * This class would serve as the entity model class synonymous
 * to the table created in derby db
 *
 */
@Entity
public class CreditCard {

	public CreditCard(String name, String limit, String balance, String creditCardNumber) {
		this.name = name;
		this.limit = limit;
		this.balance = balance;
		this.creditCardNumber = creditCardNumber;
	}
	
	public CreditCard() {
		
	}
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	
	private String limit;
	
	
	private String balance;
	
	@Id
	@NotBlank(message = "CreditCardNumber is mandatory")
	@Size(min=13,max=19)
	@CreditCardValidation
	private String creditCardNumber;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
