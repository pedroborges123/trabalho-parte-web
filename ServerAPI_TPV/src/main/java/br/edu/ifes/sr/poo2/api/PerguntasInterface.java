/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.model.Pergunta;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface PerguntasInterface {

    int CadastrarPergunta(Pergunta P) throws Throwable;

    List<Pergunta> getAll();
    
}
