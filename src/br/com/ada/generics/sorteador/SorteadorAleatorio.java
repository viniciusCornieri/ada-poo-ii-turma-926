package br.com.ada.generics.sorteador;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SorteadorAleatorio<E> extends Sorteador<E> {
    public SorteadorAleatorio(List<E> lista) {
        super(lista);
    }

    @Override
    protected int sortearIndice() {
        return ThreadLocalRandom.current().nextInt(size());
    }
}
