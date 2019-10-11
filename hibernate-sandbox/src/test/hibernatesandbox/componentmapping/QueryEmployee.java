package test.hibernatesandbox.componentmapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.componentmapping.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate_jpa_component_mapping.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();

			List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();

			for (Employee employee : employeeList) {
				System.out.println(employee);
				System.out.println(employee.getAddress());
				System.out.println();
			}

			session.getTransaction().commit();
		}
	}

}
