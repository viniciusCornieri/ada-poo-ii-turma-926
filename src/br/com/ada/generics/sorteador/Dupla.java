package br.com.ada.generics.sorteador;

public class Dupla<T, S> {

    private final T primeiro;
    private final S segundo;

    public Dupla(T primeiro, S segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public T getPrimeiro() {
        return primeiro;
    }

    public S getSegundo() {
        return segundo;
    }
}
