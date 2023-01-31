package br.com.ada.conceitos;

import java.util.ArrayList;
import java.util.List;

public class ErroNaStack {

    private static List<Byte[]> lista = new ArrayList<>();
    public static void main(String[] args) {
//        loop();
//        while (true) {
//            lista.add(new Byte[1024]);
//        }
    }

    public static void loop() {
        boolean b1 = false;
        loop();
    }
}
