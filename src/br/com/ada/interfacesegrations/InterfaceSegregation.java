package br.com.ada.interfacesegrations;

import java.util.List;

public class InterfaceSegregation {

    // Criar e implementar a interface ListaIteravel com os métodos "size" e "get(index)";
    // Criar e implementar a interface ListaRemovivel com os métodos remove e removeAll;
    public static void main(String[] args) {

        ListaIteravel<String> listaIteravel = new ListaWrapper(List.of("primeiro", "a", "segundo", "A"));

//        for (int i=0; i < listaIteravel.size(); i++) {
//            System.out.println(listaIteravel.get(i));
//        }
//
//        ImpressoraDeLista<String> impressoraDeLista = new ImpressoraDeLista<>(listaIteravel);
//        impressoraDeLista.imprimirLista();

        ListaWrapper<String> listaRemovivel = new ListaWrapper(List.of("primeiro", "a", "segundo", "A"));
        RemovedorDeA.removerAs(listaRemovivel);
        new ImpressoraDeLista<>(listaRemovivel).imprimirLista();

    }

}
