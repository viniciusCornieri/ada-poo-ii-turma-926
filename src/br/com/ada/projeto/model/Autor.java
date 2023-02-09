package br.com.ada.projeto.model;

public class Autor implements Entidade {

    private static final long serialVersionUID = 1L;

    public String nome;

    public String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String getId() {
        return nome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}
