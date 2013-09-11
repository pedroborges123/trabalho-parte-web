package br.edu.ifes.sr.poo2.api;

import br.edu.ifes.sr.poo2.api.model.Gerente;
import br.edu.ifes.sr.poo2.util.AbstractAPI;
import java.util.ArrayList;

public class GerenteImpl extends AbstractAPI implements GerenteInterface {

    private GerenteAPI gerente;

    public GerenteImpl() {

        gerente = new GerenteAPIIMpl();

    }

    @Override
    public Gerente getGerente() throws Exception {
        LogConfigImpl log = new LogConfigImpl();


        return this.gerente.get((int) log.getConfig().getGerenteId());

    }

    @Override
    public void cadastrar(String email, String senha) throws Exception {

        System.out.println("passou no cadastrar");
        Gerente ger = new Gerente();
        ger.setEmail(email);
        ger.setSenha(senha);
        int id = gerente.adicionar(ger);
        //this.addIDgerente(id);


    }

    // add o id do gerente no nosso banco de dados!!
    private void addIDgerente(int id) throws Exception {
        LogConfigImpl log = new LogConfigImpl();
        log.adicionar_Gerente((long) id);


    }

    @Override
    public boolean login(String email, String senha) {

        return gerente.login(email, senha);


    }
}
