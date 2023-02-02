package br.com.ada.zoologico.interfaces;

public class Golfinho implements Nadador, Amamentador {

    private final String nome;

    public Golfinho(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

}
