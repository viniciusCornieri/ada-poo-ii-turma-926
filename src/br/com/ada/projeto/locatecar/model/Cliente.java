package br.com.ada.projeto.locatecar.model;

public abstract class Cliente implements Entidade<String> {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
