package test.hibernatesandbox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
//		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimzone=UTC";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimzone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";

		System.out.println("Connecting to db");
		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);) {
			System.out.println("Connected to db");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
