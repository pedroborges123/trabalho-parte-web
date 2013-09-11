/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Gerente;

/**
 *
 * @author Pedro
 */
public interface GerenteInterface {

    void cadastrar(String email, String senha) throws Exception;

    Gerente getGerente() throws Exception;

    boolean login(String email, String senha);
    
}
