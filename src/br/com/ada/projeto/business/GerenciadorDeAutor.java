package br.com.ada.projeto.business;

import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.persistence.AutorRepository;
import br.com.ada.projeto.persistence.Repository;

public class GerenciadorDeAutor {

    private final AutorRepository repository;

    public GerenciadorDeAutor(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor adicionarAutor(String nome, String nacionalidade) {
        Autor novoAutor = new Autor(nome, nacionalidade);
        Autor autorSalvo = repository.salvar(novoAutor);
        return autorSalvo;
    }
}
