package br.com.ada.interfacesegrations;

public class ImpressoraDeLista<E> {

    private final ListaIteravel<E> listaIteravel;

    public ImpressoraDeLista(ListaIteravel<E> listaIteravel) {
        this.listaIteravel = listaIteravel;
    }

    public void imprimirLista() {
        listaIteravel.forEach(System.out::println);
    }
}
