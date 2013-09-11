package br.edu.ifes.poo2.model;

public class Resposta {

    private int id;
    private String resposta;
    private Boolean ehcorreta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Boolean getEhcorreta() {
        return ehcorreta;
    }

    public void setEhcorreta(Boolean ehcorreta) {
        this.ehcorreta = ehcorreta;
    }
}
