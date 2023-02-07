package br.com.ada.generics.sorteador;

import java.util.List;

public class SorteadorMediano<E> extends Sorteador<E> {
    public SorteadorMediano(List<E> lista) {
        super(lista);
    }

    @Override
    protected int sortearIndice() {
        return size() / 2;
    }
}
