package br.com.rafael.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static String banco = "jdbc:postgresql://localhost:5432/biblioteca?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";	

	public static Connection getCon() {
		Connection con = null;		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(banco, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
