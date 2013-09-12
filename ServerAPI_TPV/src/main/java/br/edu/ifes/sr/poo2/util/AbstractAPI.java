package br.edu.ifes.sr.poo2.util;


import br.edu.ifes.sr.poo2.api.util.ClientAPIUtil;

import com.google.gson.Gson;

public abstract class AbstractAPI {
	//alterar a URL
	protected String URL_servicoTerceiro = "http://localhost:8080/QuizDiablo3/rest/";
	
	protected Gson gson = new Gson();
	
	protected ClientAPIUtil clientAPIUtil = new ClientAPIUtil();
	
	
}
