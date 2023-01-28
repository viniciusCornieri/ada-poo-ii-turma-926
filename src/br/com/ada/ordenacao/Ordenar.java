package br.com.ada.ordenacao;

import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        Pessoa vinicius = new Pessoa("Vinicius", LocalDate.of(1991, Month.DECEMBER, 15));
        lista.add(vinicius);
        Pessoa maria = new Pessoa("Ana", LocalDate.of(1991, Month.DECEMBER, 15));
        lista.add(maria);
        lista.add(new Pessoa("Osvaldo", LocalDate.of(1990, Month.APRIL, 10)));
        lista.add(new Pessoa("Serafim", LocalDate.of(1992, Month.JUNE, 05)));
        lista.add(new Pessoa("Bruna", LocalDate.of(1991, Month.DECEMBER, 15)));
        System.out.println("Lista NAO ordenada: " +lista);
//        ComparadorDePessoaPorNome comparadorDePessoaPorNome = new ComparadorDePessoaPorNome();
//        Collections.sort(lista, comparadorDePessoaPorNome);
        lista.sort(Pessoa.COMPARADOR_POR_IDADE_E_NOME);
//        lista.sort(Comparator.comparing(Pessoa::getNome));
        System.out.println("Lista ordenada: " + lista);

        System.out.println("vinicius.compareTo(maria) = " + vinicius.compareTo(maria));

    }
}
