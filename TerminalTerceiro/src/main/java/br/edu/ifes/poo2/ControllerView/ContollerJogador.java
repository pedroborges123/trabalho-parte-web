package br.edu.ifes.poo2.ControllerView;


import br.edu.ifes.sr.poo2.api.JogadorImpl;
import javax.faces.bean.SessionScoped;
import br.edu.ifes.sr.poo2.api.JogadorInterface;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "Controllerjogador")
@SessionScoped
public class ContollerJogador {

	
	private JogadorInterface jogador;
        private String email;
        private String senha;
	
	public String preparaLogar(){
            this.jogador = new JogadorImpl();
            this.email = this.senha = "";
            return "/paginasjogo/jogologin";
        }
	
	
	
	
}
