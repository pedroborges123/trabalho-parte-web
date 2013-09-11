package br.edu.ifes.sr.poo2.model;



public class Jogador extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String email;
	

	private String senha;
	

	private String username;
	

	private long score;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getScore() {
		return score;
	}


	public void setScore(long score) {
		this.score = score;
	}
	
	
	
}
