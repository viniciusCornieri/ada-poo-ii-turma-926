package br.com.ada.interfacesegrations;

public interface ListaIteravel<E> extends Iterable<E> {

    int size();

    E get(int index);


}
