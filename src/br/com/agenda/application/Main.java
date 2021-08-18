package br.com.agenda.application;

import java.util.Date;

import br.com.agenda.Contato;
import br.com.agenda.dao.ContatoDAO;

public class Main {
	
	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Lucas Barbosa");
		contato.setIdade(19);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);
		
		//Mostrar registros<T>
		
		for(Contato c : contatoDAO.getContatos()) {
			System.out.println("Contatos: " + c.getNome() + " Idade: " + c.getIdade() + " Cadastro: " + c.getDataCadastro());
		}
	}
}
