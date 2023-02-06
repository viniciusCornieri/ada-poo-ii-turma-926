package br.com.ada.generics.sorteador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sorteador<E> {

    private final List<E> lista;

    public Sorteador(List<E> lista) {
        this.lista = lista;
    }

    public Dupla<E, Integer> sortear() {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia");
        }

        int indiceSorteado = ThreadLocalRandom.current().nextInt(lista.size());
        E elementoSorteado = lista.remove(indiceSorteado);
        return new Dupla<>(elementoSorteado, indiceSorteado);
    }

    public List<Grupo<E>> agrupar(int quantidadeDeGrupos) {
        List<Grupo<E>> grupos = inicializarGrupos(quantidadeDeGrupos);

        dividirEmGrupos(quantidadeDeGrupos, grupos);

        return grupos;
    }

    private void dividirEmGrupos(int quantidadeDeGrupos, List<Grupo<E>> grupos) {
        int indiceGrupoAtual = 0;
        while (hasNext()) {
            Dupla<E, Integer> elementoEIndiceSorteado = sortear();
            E elementoSorteado = elementoEIndiceSorteado.primeiro();
            int indiceSorteado = elementoEIndiceSorteado.segundo();
            System.out.println("elemento sorteado %s para o indice %s".formatted(elementoSorteado, indiceSorteado));
            grupos.get(indiceGrupoAtual).adicionarNoGrupo(elementoSorteado);
            indiceGrupoAtual++;
            if (indiceGrupoAtual == quantidadeDeGrupos) {
                indiceGrupoAtual = 0;
            }
        }
    }

    private boolean hasNext() {
        return !lista.isEmpty();
    }

    private List<Grupo<E>> inicializarGrupos(int quantidadeDeGrupos) {
        List<Grupo<E>> grupos = new ArrayList<>();
        for (int i = 0; i < quantidadeDeGrupos; i++) {
            grupos.add(new Grupo<>());
        }
        return grupos;
    }
}
