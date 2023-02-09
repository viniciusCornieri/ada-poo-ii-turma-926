package br.com.ada.interfacesegrations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaWrapper<E> implements ListaIteravel<E>, ListaRemovivel<E> {

    private final List<E> lista;

    public ListaWrapper(List<E> lista) {
        this.lista = new ArrayList<>(lista);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public E get(int index) {
        return lista.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return lista.iterator();
    }

    @Override
    public boolean remove(E elemento) {
        return lista.remove(elemento);
    }

    @Override
    public boolean removeAll(List<E> elemento) {
        return lista.removeAll(elemento);
    }
}
