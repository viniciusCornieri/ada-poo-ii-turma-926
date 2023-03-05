package br.com.ada.projeto.biblioteca.business;

import br.com.ada.projeto.biblioteca.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.model.Livro;
import br.com.ada.projeto.biblioteca.persistence.Repository;

import java.util.List;

public class GerenciadorDeLivro {

    public static final String LIVRO_DESCRICAO_DA_CLASSE = "Livro";
    private final Repository<Livro> repositoryDeLivros;

    public GerenciadorDeLivro(Repository<Livro> repositoryDeLivros) {
        this.repositoryDeLivros = repositoryDeLivros;
    }

    public Livro adicionarLivro(String titulo, String isbn, Autor autor) {

        if (existeLivro(isbn)) {
            throw new RegistroJaExistenteException(LIVRO_DESCRICAO_DA_CLASSE, isbn);
        }

        Livro novoLivro = new Livro(titulo, isbn, autor);
        repositoryDeLivros.salvar(novoLivro);
        return novoLivro;
    }

    public boolean existeLivro(String isbn) {
        return repositoryDeLivros.consultar(isbn) != null;
    }

    public List<Livro> listarTodos() {
        return repositoryDeLivros.listarTodos();
    }

    public Paginavel<Livro> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

}
