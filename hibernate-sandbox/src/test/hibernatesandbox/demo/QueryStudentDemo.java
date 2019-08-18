package test.hibernatesandbox.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> studentList = session.createQuery("from Student").getResultList();
			displayStudents(studentList);
			System.out.println();
			studentList = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			displayStudents(studentList);
			session.getTransaction().commit();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

}
