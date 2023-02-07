package br.com.ada.generics.sorteador;

import java.util.List;

public abstract class Sorteador<E> {

    private final List<E> lista;

    public Sorteador(List<E> lista) {
        this.lista = lista;
    }

    public Dupla<E, Integer> sortear() {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia");
        }

        int indiceSorteado = sortearIndice();
        E elementoSorteado = lista.remove(indiceSorteado);
        return new Dupla<>(elementoSorteado, indiceSorteado);
    }

    protected abstract int sortearIndice();
//    {
//        return switch (tipoDeSorteio) {
//            case ALEATORIO ->  ThreadLocalRandom.current().nextInt(lista.size());
//            case CRESCENTE -> 0;
//            case DECRESCENTE -> lista.size() - 1;
//            case MEIO -> lista.size() /2;
//        };
//    }

    protected int size() {
        return lista.size();
    }

    public boolean hasNext() {
        return !lista.isEmpty();
    }
}
