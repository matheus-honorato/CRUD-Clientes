package br.com.loja.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.loja.factory.ConnectionFactory;
import br.com.loja.model.Cliente;

public class ClienteDAO {
	
	public void Cadastro(Cliente cliente) {
		String sql = "INSERT INTO clientes(nome, sobrenome, senha, email, dataCadastro) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		
		try {
			// Criando uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getSobrenome());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getEmail());
			pstm.setDate(5, new Date(cliente.getDataCadastro().getTime()));
			
			pstm.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception et){
				et.printStackTrace();
			}
			
			
		}
	}
}
