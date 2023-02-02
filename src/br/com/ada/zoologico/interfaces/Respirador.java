package br.com.ada.zoologico.interfaces;

public interface Respirador {

    default void respirar() {
        System.out.println("Morcego respirando");
    }
}
