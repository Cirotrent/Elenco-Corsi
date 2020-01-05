package Ciro.Corsi.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static final String jdbcURL = "jdbc:mysql://127.0.0.1/iscritticorsi?user=root&password=Roccabianca21&serverTimezone=Europe/Rome";

	private static Connection conn;

	public static Connection getConnection() {

		try {

			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL);
			}
		} catch (SQLException e) {

			System.err.println("Errore di connessione al DB!");
			throw new RuntimeException(e);
		}

		return conn;
	}

}
