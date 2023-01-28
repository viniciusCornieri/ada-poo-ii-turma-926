package br.com.ada.zoologico.heranca;

public class Galinha extends Ave {

    @Override
    public void voar() {
        throw new RuntimeException("Não consegue voar");
    }
}
