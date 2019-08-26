package test.hibernatesandbox.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			// Remove the associated object reference, break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			System.out.println("Deleting instructorDetail: " + instructorDetail);
			session.delete(instructorDetail);
			session.getTransaction().commit();
		}
	}

}
