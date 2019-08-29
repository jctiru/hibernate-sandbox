package test.hibernatesandbox.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.demo.entity.Course;
import test.hibernatesandbox.demo.entity.Instructor;
import test.hibernatesandbox.demo.entity.InstructorDetail;
import test.hibernatesandbox.demo.entity.Review;
import test.hibernatesandbox.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			Course course = new Course("Pacman - How To Score One Million Points");
			session.save(course);
			Student student1 = new Student("John", "Doe", "johndoe@email.com");
			Student student2 = new Student("Mary", "Jane", "maryjane@email.com");
			course.addStudent(student1);
			course.addStudent(student2);
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
			System.out.println("Course: " + course);
			System.out.println("Students: " + course.getStudents());
		}
	}

}
