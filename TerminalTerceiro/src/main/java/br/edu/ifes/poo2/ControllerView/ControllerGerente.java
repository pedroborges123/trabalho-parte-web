package br.edu.ifes.poo2.ControllerView;

import br.edu.ifes.poo2.model.Ranking;
import br.edu.ifes.sr.poo2.api.GerenteImpl;
import br.edu.ifes.sr.poo2.api.JogadorImpl;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.model.LogConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "Controllergerente")
@SessionScoped
public class ControllerGerente implements Serializable {

    private String email;
    private String senha;
    private GerenteImpl gerente;
    private Boolean logado;
    private Gerente current;
    private DataModel ranking;
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    
    
    public DataModel getRanking() {
        return ranking;
    }

    public void setRanking(DataModel ranking) {
        this.ranking = ranking;
    }

    
    
    public String prepareLogar() {
         System.out.println("passou aqui");
        this.email = this.senha = "";
        this.current = new Gerente();
        this.logado = false;
        return "/paginasgerente/index";
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String logar() {
        System.out.println(email + " " + senha);
        if (this.email == null && this.senha == null) {
            return "error";

        }
        this.gerente = new GerenteImpl();
        this.logado = this.gerente.login(this.email, this.senha);

        if (!this.logado) {

            return "/paginasgerente/error";

        }

        this.current.setEmail(email);


        return "/paginasgerente/telainicial";
    }

    
    
    public String preparaCadastro(){
        this.email = this.senha = "";
        
        return "/paginasgerente/cadastrar";
    }
    
    
    

    public String cadastrar() {
        System.out.println(email + " " + senha);
        if (this.email == null && this.senha == null) {
            return "Error";

        }
        current.setEmail(email);
        current.setSenha(senha);
        gerente = new GerenteImpl();
        try {
            gerente.cadastrar(email, senha);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gerente", current);
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.logado = true;
        this.logar();

        return "paginasgerente/telainicial";

    }

    public Boolean verificaQTDGerente() {

        LogConfig log = new LogConfig();
        if (log.getGerenteId() <= 0) {
            return false;
        }

        return true;
    }
    
    
    public String showRanking(){
        
        JogadorImpl jogador = new JogadorImpl();
        ArrayList list = new ArrayList(jogador.getRanking());
        this.ranking = new ListDataModel(list);
       
        
        return "/tabelaRanking";
        
    }
    
    public int getRankingRows(){
        
        return this.ranking.getRowIndex();
    }
    
    
}
