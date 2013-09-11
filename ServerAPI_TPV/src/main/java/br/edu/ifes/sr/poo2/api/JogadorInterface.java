package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogador;

public interface JogadorInterface {

	public abstract void cadastrar(Jogador J) throws Exception;

	public abstract String login(String email, String senha) throws Exception;

}