package br.edu.ifes.poo2.ControllerView;

import br.edu.ifes.poo2.model.Servico;
import br.edu.ifes.sr.poo2.api.JogadorImpl;
import br.edu.ifes.sr.poo2.api.ServicoImpl;
import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Nivel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "Controllerjogo")
@SessionScoped
public class ControllerJogo implements Serializable {

    private String email;
    private String senha;
    private ServicoImpl servico;
    private Jogador current = new Jogador();
    private String username;
    private DataModel servicoList;
    private String usernameCurrent;
    private Nivel nivel;

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCurrent() {
        return usernameCurrent;
    }

    public void setUsernameCurrent(String usernameCurrent) {
        this.usernameCurrent = usernameCurrent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Jogador getCurrent() {
        return current;
    }

    public void setCurrent(Jogador current) {
        this.current = current;
    }

    public DataModel getServicoList() {
        return servicoList;
    }

    public void setServicoList(DataModel servicoList) {
        this.servicoList = servicoList;
    }
    
    
    
    public void mostrarCategorias(){
        
        this.servico = new ServicoImpl();
        try {
            
           
            this.servicoList = new ListDataModel(servico.showAllServices());
            
            
            
        } catch (Exception ex) {
            
            System.out.println(">>>" +ex); 
            Logger.getLogger(ControllerJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public String preparList(){
        
        //this.servicoList = null;
        this.mostrarCategorias();
        
        return "/paginasjogo/jogar/categorialista";
    }
    
    
    
    
    
    
}
