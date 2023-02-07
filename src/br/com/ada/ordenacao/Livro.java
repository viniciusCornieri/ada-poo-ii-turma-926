package br.com.ada.ordenacao;

import br.com.ada.repository.Entidade;

import java.io.Serializable;

public record Livro(String titulo, String isbn) implements Entidade, Serializable {

    @Override
    public String getId() {
        return isbn;
    }
}
