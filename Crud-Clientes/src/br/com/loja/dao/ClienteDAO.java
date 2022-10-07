package br.com.loja.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Cliente> obterClientes(){
		String sql = "select * from clientes";
		
		List<Cliente> clientes = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setSobrenome(rset.getString("Sobrenome"));
				cliente.setSenha(rset.getString("senha"));
				cliente.setEmail(rset.getString("email"));
				cliente.setDataCadastro(rset.getDate("dataCadastro"));
				
				clientes.add(cliente);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(rset!=null) {
					rset.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return clientes;
	}
}
