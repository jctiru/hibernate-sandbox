package test.hibernatesandbox.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			Student student = new Student("JC", "Tiru", "test@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}
	}

}
