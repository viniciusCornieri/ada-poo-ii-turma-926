package br.com.ada.generics.sorteador;

import java.util.ArrayList;
import java.util.List;

public class Grupo<E> {

    private List<E> grupo = new ArrayList<>();

    public void adicionarNoGrupo(E elemento) {
        grupo.add(elemento);
    }

    @Override
    public String toString() {
        return "Grupo{" + grupo + '}';
    }
}
