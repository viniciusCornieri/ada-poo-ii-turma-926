package br.com.ada.projeto.locatecar.view;

import java.util.List;
import java.util.Scanner;

public class CapturadorDeEntrada {

    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String nomeDoCampo) {
        while (true) {
            System.out.printf("Informar %s: ", nomeDoCampo);
            String entrada = scanner.nextLine();
            if (entrada != null && !entrada.isBlank()) {
                return entrada;
            }
            System.out.println("Entrada vazia não é válida, por favor informe algum valor");
        }
    }

    public static String capturarStringDentreAsPossiveis(String nomeCampo, List<String> possibilidades) {
        while (true) {
            String entrada = capturarString(nomeCampo + " %s".formatted(possibilidades));
            if (possibilidades.stream().anyMatch(p -> p.equalsIgnoreCase(entrada))) {
                return entrada;
            }
            System.out.printf("Não é uma entrada válida, somente os valores %s são aceitos.%n", possibilidades);
        }
    }
}
