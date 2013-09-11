package br.edu.ifes.poo2.model;

import br.edu.ifes.sr.poo2.model.Model;

public class Categoria extends Model {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
