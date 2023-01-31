package br.com.ada.zoologico.interfaces;

public class Galinha implements Comedor {


    @Override
    public void comer(String alimento) {
        System.out.println("Bicando ..." + alimento);
    }
}
