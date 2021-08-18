package br.com.agenda.application;

import java.sql.SQLException;
import java.util.Date;

import br.com.agenda.Contato;
import br.com.agenda.dao.ContatoDAO;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		ContatoDAO contatoDAO = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Flavio Alexandre");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		
		//contatoDAO.save(contato);
		
		Contato c1 = new Contato();
		c1.setNome("Lucas Santos");
		c1.setIdade(20);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		//contatoDAO.update(c1);
		
		contatoDAO.deleteByID(5);
		
		//Mostrar registros<T>
		
		for(Contato c : contatoDAO.getContatos()) {
			System.out.println("Contatos: " + c.getNome() + " Idade: " + c.getIdade() + " Cadastro: " + c.getDataCadastro());
		}
	}
}
