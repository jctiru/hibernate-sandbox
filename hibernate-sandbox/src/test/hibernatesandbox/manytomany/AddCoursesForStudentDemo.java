package test.hibernatesandbox.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;
import test.hibernatesandbox.demo.entity.Review;
import test.hibernatesandbox.demo.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg5.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			System.out.println("Loaded student: " + student);
			System.out.println("Courses: " + student.getCourses());
			Course course1 = new Course("Rubik's Cube - How to Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
			course1.addStudent(student);
			course2.addStudent(student);
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
		}
	}

}
