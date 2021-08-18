package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import br.com.agenda.Contato;
import br.com.agenda.connection.ConnectionMysql;

public class ContatoDAO {
	
	public void save(Contato contato) {

		String sqlQuery = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionMysql.createConnectionToMySQL();
			
			statement = (PreparedStatement) conn.prepareStatement(sqlQuery);
			statement.setString(1, contato.getNome());
			statement.setInt(2, contato.getIdade());
			statement.setDate(3, new Date(contato.getDataCadastro().getTime()));
			statement.execute();
			
			System.out.println("Executado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Contato> getContatos() {
		String sqlQuery = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn = ConnectionMysql.createConnectionToMySQL();
			
			statement = (PreparedStatement) conn.prepareStatement(sqlQuery);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Contato contato = new Contato();
				
				contato.setId(resultSet.getInt("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setIdade(resultSet.getInt("idade"));
				contato.setDataCadastro(resultSet.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {		
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return contatos;
	}
}
