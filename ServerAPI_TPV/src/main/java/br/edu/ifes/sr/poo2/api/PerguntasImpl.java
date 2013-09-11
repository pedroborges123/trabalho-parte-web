package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Gerente;
import com.sun.jersey.api.client.ClientResponse;

import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class PerguntasImpl extends AbstractAPI implements PerguntasInterface {

    public PerguntasImpl() {
        URL_serviçoTerceiro += "/perguntas";
    }

    @Override
    public int CadastrarPergunta(br.edu.ifes.sr.poo2.model.Pergunta P) throws Throwable {

        String PerguntaJson = gson.toJson(P);

        ClientResponse response = clientAPIUtil.post(URL_serviçoTerceiro + "/add", PerguntaJson);

        String retorno = response.getEntity(String.class);

        Integer id = new Integer(retorno.trim());

        if (id == -1) {
            throw new Exception("ValueExist");
        }

        return id;



    }

    @Override
    public List<Pergunta> getAll() {

        ClientResponse response = clientAPIUtil.get(URL_serviçoTerceiro + "/getall");

        String jsonResposta = response.getEntity(String.class);

        Type arrayListPergunta = new TypeToken<List<Pergunta>>() {
        }.getType();

        List<Pergunta> perguntas = gson.fromJson(jsonResposta, arrayListPergunta);

        return perguntas;


    }
}
