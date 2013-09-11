package br.edu.ifes.sr.poo2.model;

import br.edu.ifes.sr.poo2.api.model.Model;

public class Resposta extends Model {

    private static final long serialVersionUID = 1L;
    private String valor;
    private Boolean respostacorreta;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getRespostacorreta() {
        return respostacorreta;
    }

    public void setRespostacorreta(Boolean respostacorreta) {
        this.respostacorreta = respostacorreta;
    }
    
}
