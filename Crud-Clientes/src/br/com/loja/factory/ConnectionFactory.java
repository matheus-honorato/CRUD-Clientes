package br.com.loja.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jdbc://mysql:localhost:3306/";

	public static void main(String[] args) throws Exception {
		Connection connection = null;
		
		try {
			// Class usada pela jvm
			Class.forName("com.mysql.jdbc.Driver");
			
			//Realizando conexao com o banco
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
		} catch(ClassNotFoundException ex){
			System.out.println("Drive do banco n�o foi localizado");
		} catch(SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
		} finally {
			if(connection != null) {
				System.out.println("Conex�o realizada com sucesso");
				connection.close();
			}
		}
	}
	
}