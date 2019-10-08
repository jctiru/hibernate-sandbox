package test.hibernatesandbox.inheritance.singletable.entity;

import javax.persistence.Entity;

@Entity
public class Check extends Payment {

	private String checkNumber;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

}
