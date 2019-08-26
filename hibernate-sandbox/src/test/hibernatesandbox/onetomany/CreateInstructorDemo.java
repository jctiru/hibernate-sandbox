package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg3.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			Instructor newInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail newInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"Luv 2 code!!!");
			newInstructor.setInstructorDetail(newInstructorDetail);
			session.beginTransaction();
			session.save(newInstructor);
			session.getTransaction().commit();
		}
	}

}
