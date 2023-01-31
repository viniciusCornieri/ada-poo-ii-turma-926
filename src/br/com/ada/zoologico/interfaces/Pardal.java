package br.com.ada.zoologico.interfaces;

public class Pardal implements Comedor, Voador {
    @Override
    public void voar() {
        System.out.println("Voando");
    }
}
