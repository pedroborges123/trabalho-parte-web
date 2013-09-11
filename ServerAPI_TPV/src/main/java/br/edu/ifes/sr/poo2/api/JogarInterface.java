/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Jogo;
import br.edu.ifes.sr.poo2.api.model.Nivel;

/**
 *
 * @author Pedro
 */
public interface JogarInterface {

    Jogo jogar(String username, String URLServico, Nivel nivel);

    void salvar(String URLServico, Jogo jogo, String username);
    
}
