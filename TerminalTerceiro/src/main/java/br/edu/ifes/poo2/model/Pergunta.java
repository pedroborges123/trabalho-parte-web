package br.edu.ifes.poo2.model;

import br.edu.ifes.sr.poo2.model.Nivel;
import java.util.ArrayList;
import java.util.List;

public class Pergunta {
	
	private String valor;

        private Nivel nivel;
        
	private List<Resposta> respostas = new ArrayList<Resposta>();

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	public void add(Resposta resposta)
	{
		this.respostas.add(resposta);
	}

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    

    

   
		
	

}
