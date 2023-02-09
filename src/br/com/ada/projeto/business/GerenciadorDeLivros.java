package br.com.ada.projeto.business;

import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.Repository;

public class GerenciadorDeLivros {

    private final Repository<Livro> repositoryDeLivros;

    public GerenciadorDeLivros(Repository<Livro> repositoryDeLivros) {
        this.repositoryDeLivros = repositoryDeLivros;
    }


}
