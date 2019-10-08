package test.hibernatesandbox.inheritance.singletable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.inheritance.singletable.entity.Check;
import test.hibernatesandbox.inheritance.singletable.entity.CreditCard;
import test.hibernatesandbox.inheritance.singletable.entity.Payment;

public class QueryPayment {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate_jpa_single_table.cfg.xml")
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(CreditCard.class)
				.addAnnotatedClass(Check.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();

			List<Payment> paymentList = session.createQuery("from Payment", Payment.class).getResultList();
			System.out.println("All payments:");
			paymentList.forEach(System.out::println);

			System.out.println();
			List<CreditCard> creditCardList = session.createQuery("from CreditCard", CreditCard.class).getResultList();
			System.out.println("All credit cards:");
			creditCardList.forEach(System.out::println);

			System.out.println();
			List<Check> checkList = session.createQuery("from Check", Check.class).getResultList();
			System.out.println("All checks:");
			checkList.forEach(System.out::println);

			session.getTransaction().commit();
		}
	}

}
