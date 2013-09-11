/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.ControllerView;

import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.api.PerguntasImpl;
import br.edu.ifes.sr.poo2.model.Nivel;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "Controllerpergunta")
@SessionScoped
public class ControllerPergunta implements Serializable{

    private String pergunta;
    private Nivel nivel;
    private String resposta1;
    private Boolean resp1;
    private String resposta2;
    private Boolean resp2;
    private String resposta3;
    private Boolean resp3;
    private Pergunta per;
    private ArrayList<Resposta> respostasList;
    private PerguntasImpl perguntaAPI;
    private DataModel perguntas;
    

    public String getPergunta() {
        return pergunta;
    }

    public DataModel getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(DataModel perguntas) {
        this.perguntas = perguntas;
    }
    
    

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

            
    public Boolean getResp1() {
        return resp1;
    }

    public void setResp1(Boolean resp1) {
        this.resp1 = resp1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public Boolean getResp2() {
        return resp2;
    }

    public void setResp2(Boolean resp2) {
        this.resp2 = resp2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public Boolean getResp3() {
        return resp3;
    }

    public void setResp3(Boolean resp3) {
        this.resp3 = resp3;
    }

    public Pergunta getPer() {
        return per;
    }

    public void setPer(Pergunta per) {
        this.per = per;
    }

    public ArrayList<Resposta> getRespostasList() {
        return respostasList;
    }

    public void setRespostasList(ArrayList<Resposta> respostasList) {
        this.respostasList = respostasList;
    }

    public String prepararCadastro() {

        this.pergunta = this.resposta1 = this.resposta2 = this.resposta3 = "";
        this.resp1 = this.resp2 = this.resp3 = false;
        this.per = new Pergunta();
        this.respostasList = new ArrayList<Resposta>();
        return "/paginasgerente/perguntas/cadastrar";
    }

    public String cadastrarPergunta() {
        ArrayList<br.edu.ifes.sr.poo2.model.Resposta> res = new ArrayList<br.edu.ifes.sr.poo2.model.Resposta>();
        br.edu.ifes.sr.poo2.model.Resposta r = new br.edu.ifes.sr.poo2.model.Resposta();
        r.setValor(resposta1);
        r.setRespostacorreta(resp1);
        this.respostasList.add(r);
        res.add(r); 

        r = new br.edu.ifes.sr.poo2.model.Resposta();
        r.setValor(resposta1);
        r.setRespostacorreta(resp1);
        this.respostasList.add(r);
        res.add(r); 

         r = new br.edu.ifes.sr.poo2.model.Resposta();
        r.setValor(resposta1);
        r.setRespostacorreta(resp1);
        this.respostasList.add(r);
        res.add(r); 

        this.per.setNivel(nivel);
        this.per.setValor(pergunta);
        this.per.setRespostas(this.respostasList);
        br.edu.ifes.sr.poo2.model.Pergunta p = new br.edu.ifes.sr.poo2.model.Pergunta();
        p.setNivel(nivel);
         
        
        p.setRespostas(res);
        
        try {
            this.perguntaAPI.CadastrarPergunta(p);
        } catch (Throwable ex) {
            Logger.getLogger(ControllerPergunta.class.getName()).log(Level.SEVERE, null, ex);
            return "/paginasgerente/error";
        }
        
        
        return "/paginasgerente/perguntas/listar";
    }

    public String preparaLista(){
        
        this.atualizaPergunta();
        return "/paginasgerente/perguntas/listar";
    }
    
    
    public void atualizaPergunta() {
        
        this.perguntas=  (DataModel) perguntaAPI.getAll();
        
        
    }
    
    

}

