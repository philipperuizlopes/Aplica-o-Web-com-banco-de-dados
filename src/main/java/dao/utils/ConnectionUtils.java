package main.java.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			String dbUrl = "jdbc:postgresql://192.168.0.110:5432/jogo_db";
			conn = DriverManager.getConnection(dbUrl, "postgres","postgres");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
