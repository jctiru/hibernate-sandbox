package test.hibernatesandbox.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			int instructorDetailId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			System.out.println("Instructor Detail: " + instructorDetail);
			System.out.println("Instructor: " + instructorDetail.getInstructor());
			session.getTransaction().commit();
		}
	}

}
