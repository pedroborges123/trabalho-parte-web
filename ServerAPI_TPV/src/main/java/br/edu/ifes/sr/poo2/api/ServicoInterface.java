/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Categoria;
import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.api.model.Servico;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ServicoInterface {

    void Cadastrar(Gerente G, Categoria C, String url) throws Throwable;

    List<Servico> showAllServices() throws Exception;
    
}
