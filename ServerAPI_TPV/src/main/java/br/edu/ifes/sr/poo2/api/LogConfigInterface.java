/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.model.LogConfig;

/**
 *
 * @author Pedro
 */
public interface LogConfigInterface {

    int adicionar_Gerente(long idGerente) throws Exception;

    int adicionar_Servico(long idServico) throws Exception;

    LogConfig getConfig();
    
}
