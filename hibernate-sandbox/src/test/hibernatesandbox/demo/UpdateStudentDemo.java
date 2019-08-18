package test.hibernatesandbox.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			int studentId = 1;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			System.out.println("Old student: " + student);
			student.setLastName("Dux");
			session.getTransaction().commit();
			System.out.println("Updated student: " + student);
			System.out.println();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='daffydux@email.com' where id = 1").executeUpdate();
			session.getTransaction().commit();
		}
	}

}
