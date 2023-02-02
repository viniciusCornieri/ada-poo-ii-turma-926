package br.com.ada.generics;

import br.com.ada.ordenacao.Pessoa;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExemploGenerics {

    /*
        Convenção de nomes:
        - S,U,V etc. - 2nd, 3rd, 4th types
        - V - Value (Used in Map)
        - T - Type
        - N - Number
        - K - Key (Used in Map)
        - E - Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
     */

    // Criar um método que calcula o maior e outro para o menor número entre dois números;
    public static void main(String[] args) {
        Map<String, Pessoa> mapDePessoas = new HashMap<>();
        Double dez = 10d;
        Double vinte = 20d;

        Double maior = maior(dez, vinte);
        Double menor = menor(dez, vinte);
        System.out.println("O maior numero é: " + maior);
        System.out.println("O menor numero é: " + menor);

        String a = "a";
        String b = "b";

        String maiorString = maior(a, b);
        String menorString = menor(a, b);
        System.out.println("O maior String é: " + maiorString);
        System.out.println("O menor String é: " + menorString);

        BigDecimal bdUm = BigDecimal.ONE;
        BigDecimal bdDoze = BigDecimal.valueOf(12);

        BigDecimal maiorBD = maior(bdUm, bdDoze);
        BigDecimal menorBD = menor(bdUm, bdDoze);
        System.out.println("O maior BigDecimal é: " + maiorBD);
        System.out.println("O menor BigDecimal é: " + menorBD);
    }

    private static <T extends Comparable> T menor(T primeiro, T segundo) {
        if (primeiro.compareTo(segundo) < 0) {
            return primeiro;
        }

        return segundo;
    }

    private static <T extends Comparable> T maior(T primeiro, T segundo) {
        if (primeiro.compareTo(segundo) > 0) {
            return primeiro;
        }

        return segundo;
    }

//    private static Double menor(Double primeiro, Double segundo) {
//        if (primeiro < segundo) {
//            return primeiro;
//        }
//
//        return segundo;
//    }
//
//    private static Double maior(Double primeiro, Double segundo) {
//        if (primeiro > segundo) {
//            return primeiro;
//        }
//
//        return segundo;
//    }
//
//    private static Integer menor(Integer primeiro, Integer segundo) {
//        if (primeiro < segundo) {
//            return primeiro;
//        }
//
//        return segundo;
//    }
//
//    private static Integer maior(Integer primeiro, Integer segundo) {
//        if (primeiro > segundo) {
//            return primeiro;
//        }
//
//        return segundo;
//    }
//
//    private static String menor(String primeiro, String segundo) {
//        if (primeiro.compareTo(segundo) < 0) {
//            return primeiro;
//        }
//
//        return segundo;
//    }
//
//    private static String maior(String primeiro, String segundo) {
//        if (primeiro.compareTo(segundo) >= 0) {
//            return primeiro;
//        }
//
//        return segundo;
//    }

}
