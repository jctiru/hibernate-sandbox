package test.hibernatesandbox.inheritance.singletable.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class Check extends Payment {

	@Column(name = "check_number")
	private String checkNumber;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public String toString() {
		return "Check [checkNumber=" + checkNumber + ", toString()=" + super.toString() + "]";
	}

}
