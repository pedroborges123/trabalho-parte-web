package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogador;
import br.edu.ifes.sr.poo2.api.model.Ranking;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import java.util.List;



public class JogadorImpl extends AbstractAPI implements JogadorInterface{

	JogadorAPI jogador;
	
	
	public JogadorImpl(){
		
		jogador = new JogadorAPIIMpl();
		
	}
	
	/* (non-Javadoc)
	 * @see br.edu.ifes.sr.poo2.api.JogadorInterface#cadastrar(br.edu.ifes.sr.poo2.api.model.Jogador)
	 */
	public void cadastrar(Jogador J ) throws Exception{
		
		jogador.adicionar(J);
	
	}
	
	/* (non-Javadoc)
	 * @see br.edu.ifes.sr.poo2.api.JogadorInterface#login(java.lang.String, java.lang.String)
	 */
	public String login(String email, String senha) throws Exception{
		
		return jogador.login(email, senha);
	}
	
	public List<Ranking> getRanking(){
            
            return jogador.getRanking();
            
        }
        
        
}
