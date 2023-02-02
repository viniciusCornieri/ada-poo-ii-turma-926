package br.com.ada.ordenacao;

import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ordenar {

    // Ordenar a lista de pessoas por nome em ordem alfabética.
    // Ordenar as pessoas por idade da mais nova para a mais velha.
    // Ordernar as pessoas por idade e por nome
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        LocalDate dia15 = LocalDate.parse("2023-01-15");
        LocalDate dia17 = LocalDate.parse("2023-01-17");
        LocalDateTime now = LocalDateTime.now();

        System.out.println(dia17.compareTo(dia15));

        Pessoa vinicius = new Pessoa("Vinicius", LocalDate.of(1991, Month.DECEMBER, 15), "88291073015");
        lista.add(vinicius);
        Pessoa maria = new Pessoa("Ana", LocalDate.of(1991, Month.DECEMBER, 15), "41693734052");
        lista.add(maria);
        lista.add(new Pessoa("Osvaldo", LocalDate.of(1990, Month.APRIL, 10), "83899011023"));
        lista.add(new Pessoa("Serafim", LocalDate.of(1992, Month.JUNE, 05), "02758255073"));
        lista.add(new Pessoa("Bruna", LocalDate.of(1991, Month.DECEMBER, 15), "73104978050"));
        System.out.println("Lista NAO ordenada: " +lista);
//        ComparadorDePessoaPorNome comparadorDePessoaPorNome = new ComparadorDePessoaPorNome();
//        Collections.sort(lista, comparadorDePessoaPorNome);
        lista.sort(Pessoa.COMPARADOR_POR_IDADE);
//        lista.sort(Comparator.comparing(Pessoa::getNome));
        System.out.println("Lista ordenada: " + lista);


        System.out.println("vinicius.compareTo(maria) = " + vinicius.compareTo(maria));

//        Instant start = Instant.now();
//        System.out.println(LocalDateTime.now());
//        try {
//            metodoQueLevaUmTempo();
//            System.out.println(LocalDateTime.now());
//        } finally {
//            System.out.println("Levou %s ms para executar".formatted(Duration.between(start, Instant.now()).toMillis()));
//        }
    }

    private static void metodoQueLevaUmTempo() {
        try {
            Thread.sleep(500l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
