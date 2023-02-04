package br.com.ada.zoologico.interfaces;

public class Tubarao implements Comedor, Nadador {
    @Override
    public String getNome() {
        return "Tubarao";
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando rápido");
    }
}
