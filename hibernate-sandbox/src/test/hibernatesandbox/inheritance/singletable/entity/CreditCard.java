package test.hibernatesandbox.inheritance.singletable.entity;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Payment{

	private String creditCardNumber;

	public String getCreditCard() {
		return creditCardNumber;
	}

	public void setCreditCard(String creditCard) {
		this.creditCardNumber = creditCard;
	}

}
