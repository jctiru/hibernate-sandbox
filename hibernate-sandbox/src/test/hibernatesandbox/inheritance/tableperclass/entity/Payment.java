package test.hibernatesandbox.inheritance.tableperclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 
 * References
 * 
 * Hibernate 5.2
 * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
 *
 * DefaultIdentifierGeneratorFactory for generator strategy
 * https://github.com/hibernate/hibernate-orm/blob/master/hibernate-core/src/main/java/org/hibernate/id/factory/internal/DefaultIdentifierGeneratorFactory.java
 * 
 * TableGenerator (enhanced-table)
 * https://github.com/hibernate/hibernate-orm/blob/master/hibernate-core/src/main/java/org/hibernate/id/enhanced/TableGenerator.java
 * 
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {

	@Id
	@GenericGenerator(name = "table", strategy = "enhanced-table", parameters = {
			@Parameter(name = "table_name", value = "hibernate_sequences"),
			@Parameter(name = "prefer_entity_table_as_segment_value", value = "true") })
	@GeneratedValue(generator = "table", strategy = GenerationType.TABLE)
	@Column(name = "id")
	private int id;

	@Column(name = "amount")
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + "]";
	}

}
