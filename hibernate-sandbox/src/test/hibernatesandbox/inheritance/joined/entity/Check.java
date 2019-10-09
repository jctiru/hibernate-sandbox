package test.hibernatesandbox.inheritance.joined.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bank_check")
@PrimaryKeyJoinColumn(name = "id")
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
