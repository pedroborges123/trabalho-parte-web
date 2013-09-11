package br.edu.ifes.poo2.ControllerView;

import br.edu.ifes.sr.poo2.api.JogadorImpl;
import br.edu.ifes.sr.poo2.model.Jogador;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

@ManagedBean(name = "Controllerjogo")
@SessionScoped
public class ControllerJogo implements Serializable{

    private String email;
    private String senha;
    private JogadorImpl jogoAPI;
    private Jogador current = new Jogador();
    private String username;
    private DataModel categoria;
    private String usernameCurrent;

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

    
    
    
    
    public String logar() {
        System.out.println(email + " " + senha);
        if (this.email == null && this.senha == null) {
            return "error";

        }
        this.jogoAPI = new JogadorImpl();
        try {
            //this.current.setEmail(this.jogoAPI.login(this.email, this.senha));
            this.usernameCurrent =  this.jogoAPI.login(this.email, this.senha);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usernameCurrent", this.usernameCurrent);
            if (usernameCurrent == null) {

                return "/paginasjogo/error";

            }

            //this.current.setEmail(email);

        } catch (Exception ex) {
            Logger.getLogger(ControllerJogo.class.getName()).log(Level.SEVERE, null, ex);
            return "/paginasjogo/error";
        }
        return "/paginasjogo/telainicial";
    }
    
    public String cadastrar() {
        System.out.println(email + " " + senha);
        if (this.email == null && this.senha == null) {
            return "/paginasjogo/error";

        }
        //current.setEmail(email);
       // current.setSenha(senha);
        //current.setUsername(username);
        this.jogoAPI = new JogadorImpl();
        try {
            br.edu.ifes.sr.poo2.api.model.Jogador jogador = new br.edu.ifes.sr.poo2.api.model.Jogador();
            jogador.setEmail(email);
            jogador.setSenha(senha);
            jogador.setUsername(username);
            jogoAPI.cadastrar(jogador);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jogador", jogador);
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerGerente.class.getName()).log(Level.SEVERE, null, ex);
             return "/paginasjogo/error";
        }
        
        this.logar();

        return "paginasjogo/telainicial";

    }
    
    
    
    
    
    
    
}
