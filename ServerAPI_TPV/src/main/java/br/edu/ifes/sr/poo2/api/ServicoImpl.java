package br.edu.ifes.sr.poo2.api;

import java.util.List;

import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.api.model.Servico;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import java.util.ArrayList;

public class ServicoImpl extends AbstractAPI implements ServicoInterface{

	private ServicoAPI service;	
	
	
	public ServicoImpl(){
		service = new ServicoAPIIMpl();
				
	}
	
    @Override
	public void Cadastrar(Gerente G, Categoria C,String url ) throws Throwable{
		
		Servico S = new Servico();
		S.setCategoria(C);
		S.setGerente(G);
		S.setUrl(url);
		int idServico = service.adicionar(S);
		this.salvarIdServico(idServico);
		
	}
	
	private void salvarIdServico(int id) throws Exception{
		LogConfigImpl log = new LogConfigImpl();
                log.adicionar_Servico((long)id);
                
		
		
	}
	
	
    @Override
	public List<Servico> showAllServices() throws Exception{
		
                List<Servico> s = new ArrayList<Servico>();
                s = this.service.getAll();
                System.out.println(s);    
		return s;
		
		
	}

   
	
}
