package test.hibernatesandbox.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			Student student = new Student("Daffy", "Duck", "daffyduck@email.com");
			session.beginTransaction();
			session.save(student);
			System.out.println("Id: " + student.getId());
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Student: " + myStudent);
			session.getTransaction().commit();
		}
	}

}
