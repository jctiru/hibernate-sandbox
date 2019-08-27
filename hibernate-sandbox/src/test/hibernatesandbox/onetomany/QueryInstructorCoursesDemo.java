package test.hibernatesandbox.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;

public class QueryInstructorCoursesDemo {

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
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:instructorId", Instructor.class);
			query.setParameter("instructorId", instructorId);
			Instructor instructor = query.getSingleResult();
			session.getTransaction().commit();
			System.out.println("Instructor: " + instructor);
			System.out.println("Courses: " + instructor.getCourses());
		}
	}

}
