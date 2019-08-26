package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg3.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			Course newCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course newCourse2 = new Course("The Pinball Masterclass");
			instructor.addCourse(newCourse1);
			instructor.addCourse(newCourse2);
			session.save(newCourse1);
			session.save(newCourse2);
			session.getTransaction().commit();
		}
	}

}
