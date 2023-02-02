package br.com.ada.zoologico.interfaces;

public interface Amamentador extends Comedor, Respirador {

    default void amamentar() {
        System.out.println("Amamentando filhotes");
    }

}
