package test.hibernatesandbox.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {
			int studentId = 1;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			session.delete(student);
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
		}
	}

}
