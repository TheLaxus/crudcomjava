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

    public void setNome() {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade() {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro() {
        this.dataCadastro = dataCadastro;
    }


}