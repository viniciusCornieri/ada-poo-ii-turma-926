package br.com.ada.zoologico.interfaces;

public class Tilapia implements Comedor, Nadador {
    @Override
    public String getNome() {
        return "Tilapia";
    }
}
