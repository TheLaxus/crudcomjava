package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

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
}
