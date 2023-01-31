package br.com.ada.zoologico.interfaces;

public interface Nadador {

    String getNome();

    default void nadar() {
        System.out.println(getNome() + " está nadando");
    }
}
