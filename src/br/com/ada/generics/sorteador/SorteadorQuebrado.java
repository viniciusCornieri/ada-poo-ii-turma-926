package br.com.ada.generics.sorteador;

import java.util.List;

public class SorteadorQuebrado<E> extends Sorteador<E> {

    public SorteadorQuebrado(List<E> lista) {
        super(lista);
    }

    @Override
    protected int sortearIndice() {
        return -1;
    }
}
