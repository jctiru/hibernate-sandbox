package test.hibernatesandbox.inheritance.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernatesandbox.inheritance.singletable.entity.Check;
import test.hibernatesandbox.inheritance.singletable.entity.CreditCard;
import test.hibernatesandbox.inheritance.singletable.entity.Payment;

public class AddPayment {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
				.configure("hibernate_jpa_single_table.cfg.xml")
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(CreditCard.class)
				.addAnnotatedClass(Check.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();) {
			session.beginTransaction();

			CreditCard cc = new CreditCard();
			cc.setAmount(1000);
			cc.setCreditCardNumber("1234567890");

			Check ch = new Check();
			ch.setAmount(2000);
			ch.setCheckNumber("0987654321");

			session.save(cc);
			session.save(ch);

			session.getTransaction().commit();
		}
	}

}
