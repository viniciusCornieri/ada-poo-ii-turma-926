package br.com.ada.zoologico.interfaces;

public class Morcego implements Voador, Amamentador {
    @Override
    public void voar() {
        System.out.println("Voando ...");
    }
}
