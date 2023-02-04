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

        List<Nadador> nadadores = new ArrayList<>(List.of(tilapia, golfinho, tubarao));

        colocarParaNadar(nadadores);

        List<Golfinho> golfinhos = new ArrayList<>();
        golfinhos.add(golfinho);
        colocarParaNadar(golfinhos);
//        List<Object> objetos = golfinhos;

//        List objetos = golfinhos; // RAW TYPE nunca fazer
//        objetos.add(tilapia);
//        objetos.add(new Galinha());
//        Object o = objetos.get(1);
//        Golfinho golfinho1 = golfinhos.get(1);
//        if (objetos.get(1) instanceof Golfinho) {
//            Golfinho g1 = (Golfinho) objetos.get(1);
//        } else {
//            System.out.println("Alguem colocou alguma coisa diferente de golfinho na lista");
//        }
//        System.out.println(g1);

//        Golfinho tilapiaSeFazendoDeGolfinho = golfinhos.get(1);

        adicionadorDeBotoCorDeRosa(golfinhos);
        adicionadorDeBotoCorDeRosa(nadadores);
        List<BotoCorDeRosa> botoCorDeRosas = new ArrayList<>();
        botoCorDeRosas.add(new BotoCorDeRosa("Boto da amazonia"));
        adicionadorDeBotoCorDeRosa(botoCorDeRosas);

    }

    public static void colocarParaNadar(List<? extends Nadador> nadadores) {
        System.out.println("Colocando peixes para nadar:");
        for (Nadador nadador: nadadores) {
            nadador.nadar();
        }
    }

    public static void adicionadorDeBotoCorDeRosa(List<? super BotoCorDeRosa> lista) {
        lista.add(new BotoCorDeRosa("Flipper 2"));
    }


}
