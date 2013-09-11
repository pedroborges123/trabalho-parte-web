package br.edu.ifes.sr.poo2.model;

import br.edu.ifes.sr.poo2.api.model.Model;
import java.util.ArrayList;
import java.util.List;

public class Pergunta extends Model {

    private static final long serialVersionUID = 1L;
    private String valor;
    public Nivel nivel;
    private ArrayList<Resposta> respostas;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }
}
