package br.com.ada.ordenacao;

import java.math.BigDecimal;

public class BigDecimalComparacao {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE + 1);
        BigDecimal a = BigDecimal.valueOf(1.0);
        BigDecimal b = new BigDecimal("1.00");

        System.out.println(" a.compareTo(b) == 0  ? " + (a.compareTo(b) == 0));
        System.out.println(" a.equals(b)  ? " + (a.equals(b)));
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
