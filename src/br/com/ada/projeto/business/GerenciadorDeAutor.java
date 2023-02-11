package br.com.ada.projeto.business;

import br.com.ada.projeto.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.persistence.AutorRepository;
import br.com.ada.projeto.persistence.Repository;

import java.util.List;

public class GerenciadorDeAutor {

    public static final String AUTOR_DESCRICAO_CLASSE = "Autor";
    private final AutorRepository repository;

    public GerenciadorDeAutor(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor adicionarAutor(String nome, String nacionalidade) {

        if (existeAutor(nome)) {
            throw new RegistroJaExistenteException(AUTOR_DESCRICAO_CLASSE, nome);
        }

        Autor novoAutor = new Autor(nome, nacionalidade);
        Autor autorSalvo = repository.salvar(novoAutor);
        return autorSalvo;
    }

    public Autor editarAutor(String nome, String nacionalidade) {

        Autor autor = consultarPorNome(nome);
        boolean autorNaoExiste = autor == null;

        if (autorNaoExiste) {
            throw new RegistroNaoEncontradoException(AUTOR_DESCRICAO_CLASSE, nome);
        }

        autor.setNacionalidade(nacionalidade);
        repository.atualizar(autor);
        return autor;
    }

    public boolean deletarAutor(String nome) {
        return repository.deletar(nome);
    }

    public Autor consultarPorNome(String nome) {
        return repository.consultar(nome);
    }

    public boolean existeAutor(String nome) {
        return repository.consultar(nome) != null;
    }

    public List<Autor> listarTodos() {
        return repository.listarTodos();
    }
}
