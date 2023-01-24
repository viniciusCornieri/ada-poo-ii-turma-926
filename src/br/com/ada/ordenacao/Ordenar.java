package br.com.ada.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenar {

    // Ordenar a lista de pessoas por nome em ordem alfabética.
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();

        Pessoa vinicius = new Pessoa("Vinicius", LocalDate.of(1991, Month.DECEMBER, 15));
        lista.add(vinicius);
        Pessoa maria = new Pessoa("Ana", LocalDate.of(1991, Month.DECEMBER, 15));
        lista.add(maria);
        lista.add(new Pessoa("Osvaldo", LocalDate.of(1990, Month.APRIL, 10)));
        System.out.println(lista);
        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);


        System.out.println("vinicius.compareTo(maria) = " + vinicius.compareTo(maria));
    }
}
