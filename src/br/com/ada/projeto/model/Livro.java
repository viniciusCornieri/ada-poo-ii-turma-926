package br.com.ada.projeto.model;

import java.io.Serializable;

public class Livro implements Entidade {

    private static final long serialVersionUID = 1L;

    private String titulo;

    private String isbn;

    private Autor autor;

    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    @Override
    public String getId() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                '}';
    }
}
