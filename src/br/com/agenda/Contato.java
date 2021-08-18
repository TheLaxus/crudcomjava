package br.com.agenda;

import java.util.Date;

public class Contato {

    private int id;
    private String nome;
    private int idade;
    private Date dataCadastro;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String string) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date date) {
        this.dataCadastro = dataCadastro;
    }


}
