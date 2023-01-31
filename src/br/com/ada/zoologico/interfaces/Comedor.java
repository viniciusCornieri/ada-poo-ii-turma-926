package br.com.ada.zoologico.interfaces;

public interface Comedor {

     default void comer(String alimento) {
        System.out.println("Comendo ... " + alimento);
    }
}
