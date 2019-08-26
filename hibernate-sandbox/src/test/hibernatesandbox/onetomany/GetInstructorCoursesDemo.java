package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			System.out.println("Instructor: " + instructor);
			System.out.println("Courses: " + instructor.getCourses());
			session.getTransaction().commit();
		}
	}

}
