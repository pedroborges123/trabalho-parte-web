/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.ControllerView;

import br.edu.ifes.poo2.model.Gerente;
import br.edu.ifes.sr.poo2.api.PerguntasImpl;
import br.edu.ifes.sr.poo2.api.ServicoImpl;
import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Servico;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pedro
 */

@ManagedBean(name = "Controllerservico")
@SessionScoped
public class ControllerServico implements Serializable{

    private ServicoImpl service;
   
    private String categoriaDescricao;
    private String categoriaNome;
    private String url;
    

    public String getCategoriaDescricao() {
        return categoriaDescricao;
    }

    public void setCategoriaDescricao(String categoriaDescricao) {
        this.categoriaDescricao = categoriaDescricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    

    
    public String prepararServico(){
        
        service = new ServicoImpl();
        
        this.categoriaDescricao = this.categoriaNome = this.url = "";
        
        return "/paginasgerente/servico/cadastrar";
    }
    
    
    
    public String cadastrarServico(){
        
        if(this.categoriaDescricao !=null && this.categoriaNome!= null){
            Categoria categoria = new Categoria();
            categoria.setDescricao(this.categoriaDescricao);
            categoria.setNome(categoriaNome);
            try {
                this.service.Cadastrar((br.edu.ifes.sr.poo2.api.model.Gerente)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gerente") , categoria, url );
            } catch (Throwable ex) {
                Logger.getLogger(ControllerServico.class.getName()).log(Level.SEVERE, null, ex);
                return "/error";
            }
            return "/paginasgerente/servico/servicoCadastrado";
        }
        
        
        
        return "/error";
    }
    

    
    
    
}
