package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;
import test.hibernatesandbox.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg4.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			Course course = new Course("Pacman - How To Score One Million Points");
			course.addReview(new Review("Great course ... loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course..."));
			session.save(course);
			session.getTransaction().commit();
			System.out.println("Course: " + course);
			System.out.println("Reviews: " + course.getReviews());
		}
	}

}
