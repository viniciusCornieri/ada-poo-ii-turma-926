package br.com.ada.generics.sorteador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    // Criar uma classe Sorteador genérica que recebe uma lista de Elementos.
    // Essa classe deve ter um método sortear que seleciona um elemento randômico da lista,
    // remove e retorna esse elemento da Lista.

    // Adicionar no Sorteador um método chamado agrupar
    // que recebe um inteiro que representa o número de grupos a serem criados.
    // Esse método sorteará os elementos da lista
    // e adicionará nos grupos até que não tenham mais elementos.
    // Após terminar o sorteio irá retornar a lista dos grupos sorteados.

    // Adicionar novas formas de se sortear a lista, além da forma randômica.
    // Adicionar uma forma de sortear sequencialmente crescente e outra decrescente;
    public static void main(String[] args) {

//        ThreadLocalRandom.current().nextInt(1000); // 0 - 999

        List<String> lista = new ArrayList<>(List.of(
                "Bárbara Fernanda Ayres Da Silva",
                "Bruno De Oliveira",
                "Guilherme Costa E Silva",
                "Guilherme Moreira Da Silva",
                "Gustavo Amabile",
                "Hilario Henrique Silva Ribeiro",
                "Ivana Maria Feitosa Silva",
                "Ivo Augusto",
                "Job Nunes",
                "José Guilherme Da Silva Arruda",
                "Joyce Ribeiro",
                "Leonardo Almeida E Silva Oliveira",
                "Lucas Feliciano Bassetto",
                "Luciana Ferreira",
                "Marco Antonio Loureiro Lima",
                "Maria Theresa De Sousa Ferreira",
                "Matheus Felipe Lima Domingos",
                "Matheus Gaviraghi",
                "Pedro Henrique Vieira Da Silva",
                "Pedro Vitor De Toni",
                "Rachel Lizandra Borborema",
                "Renan Barbieri Segamarchi",
                "Rodrigo Veras Dos Santos",
                "Ruan Derlan Sombra Oliveira",
                "Thiago Miguel Lapazini",
                "Victor Henrique Martines"
        ));

        Agrupador<String> agrupador = new Agrupador<>(lista);
        List<Grupo<String>> grupos = agrupador.agrupar(5);
        grupos.stream()
                .forEach(System.out::println);

        List<Integer> inteiros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Agrupador<Integer> agrupadorDeInteiros = new Agrupador<>(inteiros);
        List<Grupo<Integer>> gruposInteiros = agrupadorDeInteiros.agrupar(5);
        gruposInteiros.stream()
                .forEach(System.out::println);

//        for (Grupo<String> grupo : grupos) {
//            System.out.println(grupo);
//        }

        MeuDTO meuDTO = new MeuDTO(1, "primeiro", LocalDate.now());
        System.out.println(meuDTO);


    }
}
