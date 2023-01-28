package br.com.ada.zoologico.heranca;

public class Zoologico {

    public static void main(String[] args) {
        Mamifero vaca = new Vaca();
        Peixe tilapia = new Tilapia();
        Ave pardal = new Pardal();

        vaca.comer();
        tilapia.comer();
        pardal.comer();

        vaca.amamentar();
        tilapia.nadar();
        pardal.voar();

    }
}
