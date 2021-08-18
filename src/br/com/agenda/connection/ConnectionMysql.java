package br.com.agenda.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 * Conexão com o banco de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("Conexão realizada");
			con.close();
		}
	}
}
