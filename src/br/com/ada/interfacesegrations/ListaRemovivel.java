package br.com.ada.interfacesegrations;

import java.util.List;

public interface ListaRemovivel<E> {

    boolean remove(E elemento);
    boolean removeAll(List<E> elemento);
}
