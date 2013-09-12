package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogador;
import com.google.gson.reflect.TypeToken;
import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import com.sun.jersey.api.client.ClientResponse;
import java.lang.reflect.Type;

public class JogoImpl extends AbstractAPI implements JogarInterface {

    JogoAPI jogo;

    

    public JogoImpl() {

        this.jogo = new JogoAPIImpl();
        URL_servicoTerceiro += "/jogo";
    }
    
    
    
    public Jogo jogar(String username, Nivel nivel) {
        
                Jogador jogador = new Jogador();
                
                jogador.setUsername(username);
                

		ClientResponse response = clientAPIUtil.get(URL_servicoTerceiro+"jogo/add/"+jogador+"/"+nivel);

		String jsonResposta = response.getEntity(String.class);

		Type jogoType = new TypeToken <Jogo>(){}.getType();

		Jogo novoJogo = gson.fromJson(jsonResposta, jogoType);

		return novoJogo;
	}

	public int salvarJogo(String URLServico, Jogo jogo) {

		String JSON = gson.toJson(jogo);

		System.out.println("teste "+JSON);

		ClientResponse response = clientAPIUtil.post(URLServico+"jogar/responder/", JSON);

		String retorno = response.getEntity(String.class);

		return Integer.parseInt(retorno);
	}

    @Override
    public Jogo jogar(String username, String URLServico, Nivel nivel) {

        return jogo.jogar(username, URLServico, nivel);

    }

    @Override
    public void salvar(String URLServico, Jogo jogo, String username) {

        int score = this.jogo.salvarJogo(URLServico, jogo);

        this.showPontos(score);

    }

    private int showPontos(int score) {
        return score;


    }
}
