package test.hibernatesandbox.inheritance.tableperclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class CreditCard extends Payment {

	@Column(name = "card_number")
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCard) {
		this.creditCardNumber = creditCard;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", toString()=" + super.toString() + "]";
	}

}
