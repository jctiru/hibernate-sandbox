package test.hibernatesandbox.componentmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.componentmapping.entity.Address;
import test.hibernatesandbox.componentmapping.entity.Employee;

public class AddEmployee {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate_jpa_component_mapping.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();

			Employee employee = new Employee();
			employee.setName("John Wick");

			Address address = new Address();
			address.setCity("City");
			address.setCountry("Country");
			address.setState("State");
			address.setStreetAddress("Street Address");
			address.setZipCode("Zip Code");

			employee.setAddress(address);

			session.save(employee);

			session.getTransaction().commit();
		}
	}

}
