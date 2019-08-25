package test.hibernatesandbox.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: " + instructor);

			if (instructor != null) {
				System.out.println("Deleting: " + instructor);
				session.delete(instructor);
			} else {
				System.out.println("No instructor found!");
			}

			session.getTransaction().commit();
		}
	}

}
