/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;


import br.edu.ifes.sr.poo2.api.model.Servico;
import br.edu.ifes.sr.poo2.model.LogConfig;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import java.lang.reflect.Type;


/**
 *
 * @author Pedro
 */
public class LogConfigImpl extends AbstractAPI implements LogConfigInterface{
    
    @Override
    public LogConfig getConfig() {
		
		ClientResponse response = clientAPIUtil.get(URL_servicoTerceiro+"/getID");
		
		String jsonResposta = response.getEntity(String.class);
		
		Type LogConfig = new TypeToken <LogConfig>(){}.getType();
		
		LogConfig log = gson.fromJson(jsonResposta, LogConfig);
		
		return log;
		
	}
    
    @Override
    public int adicionar_Gerente(long idGerente) throws Exception {
                
                LogConfig log = new LogConfig();
                log.setGerenteId(idGerente);
                log.setId((long)1);
        
		String LogConfigJSON = gson.toJson(log);
		
		ClientResponse response = clientAPIUtil.post(URL_servicoTerceiro+"/add/", LogConfigJSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}
    
    
    @Override
    public int adicionar_Servico(long idServico) throws Exception {
                
                LogConfig log = new LogConfig();
                log.setServicoId(idServico);
                log.setId((long)1);
        
		String LogConfigJSON = gson.toJson(log);
		
		ClientResponse response = clientAPIUtil.post(URL_servicoTerceiro+"/add/", LogConfigJSON);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		if (id == -1) throw new Exception("ValueExist");
		
		return id;
	}
    
}
