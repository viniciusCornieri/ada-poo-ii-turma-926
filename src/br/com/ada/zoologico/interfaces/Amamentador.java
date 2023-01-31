package br.com.ada.zoologico.interfaces;

public interface Amamentador extends Comedor {

    default void amamentar() {
        System.out.println("Amamentando filhotes");
    }
}
