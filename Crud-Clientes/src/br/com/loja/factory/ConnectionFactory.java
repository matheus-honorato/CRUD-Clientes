package br.com.loja.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/loja";

	
	public static Connection createConnectionToMySQL() throws Exception {
		Connection connection = null;
		
		try {
			// Class usada pela jvm
			Class.forName("com.mysql.jdbc.Driver");
			
			//Realizando conexao com o banco
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
		} catch(ClassNotFoundException ex){
			System.out.println("Drive do banco não foi localizado");
		} catch(SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
		}
		
		return connection;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = createConnectionToMySQL();
		
		if(conn != null) {
			System.out.println("Conexão realizada com sucesso");
			conn.close();
		}
	}
	
}