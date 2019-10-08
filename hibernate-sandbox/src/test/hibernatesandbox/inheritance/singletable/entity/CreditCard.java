package test.hibernatesandbox.inheritance.singletable.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {

	@Column(name = "card_number")
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCard) {
		this.creditCardNumber = creditCard;
	}

}
