package br.com.ada.zoologico.interfaces;

import java.util.List;

public class Zoologico {

    public static void main(String[] args) {
        Amamentador vaca = new Vaca();
        Tilapia tilapia = new Tilapia();
        Voador pardal = new Pardal();
        int a = 12;

        vaca.comer("Pasto");

        pardal.voar();

        Tubarao tubarao = new Tubarao();
        Nadador golfinho = new Golfinho("Flipper");

        List<Nadador> nadadores = List.of(tilapia, golfinho, tubarao);

        colocarParaNadar(nadadores);

    }

    public static void colocarParaNadar(List<Nadador> nadadores) {
        System.out.println("Colocando peixes para nadar:");
        for (Nadador nadador: nadadores) {
            nadador.nadar();
        }
    }


}
