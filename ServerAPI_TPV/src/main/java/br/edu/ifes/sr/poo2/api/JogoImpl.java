package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;
import br.edu.ifes.sr.poo2.util.AbstractAPI;

public class JogoImpl extends AbstractAPI implements JogarInterface{

	JogoAPI jogo;
	
	
	public JogoImpl(){
		
		this.jogo = new JogoAPIImpl();
		
	}
	
    @Override
	public Jogo jogar (String username, String URLServico, Nivel nivel){
		
		return jogo.jogar(username, URLServico, nivel);
		
	}
	
    @Override
	public void salvar(String URLServico, Jogo jogo, String username){
		
		int score = this.jogo.salvarJogo(URLServico, jogo);
		
		this.showPontos(score);
		
	}
	
	private int showPontos(int score) {
		return score;
		
		
	}
	
}
