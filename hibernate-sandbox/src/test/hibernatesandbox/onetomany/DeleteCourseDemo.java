package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg3.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			int courseId = 1;
			Course course = session.get(Course.class, courseId);
			System.out.println("Deleting course: " + course);
			session.delete(course);
			session.getTransaction().commit();
		}
	}

}
