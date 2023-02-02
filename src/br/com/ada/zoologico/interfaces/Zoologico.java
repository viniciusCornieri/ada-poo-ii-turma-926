package br.com.ada.zoologico.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {

    public static void main(String[] args) {
        Amamentador vaca = new Vaca();
        Tilapia tilapia = new Tilapia();
        Voador pardal = new Pardal();

        vaca.comer("Pasto");

        pardal.voar();

        Tubarao tubarao = new Tubarao();
        Golfinho golfinho = new Golfinho("Flipper");

        List<Nadador> nadadores = List.of(tilapia, golfinho, tubarao);

        colocarParaNadar(nadadores);

        List<Golfinho> golfinhos = new ArrayList<>();
        golfinhos.add(golfinho);
//        colocarParaNadar(golfinhos);

//        List objetos = golfinhos; // RAW TYPE nunca fazer
//        objetos.add(tilapia);

//        Golfinho golfinho1 = golfinhos.get(1);

    }

    public static void colocarParaNadar(List<Nadador> nadadores) {
        System.out.println("Colocando peixes para nadar:");
        for (Nadador nadador: nadadores) {
            nadador.nadar();
        }
    }


}
