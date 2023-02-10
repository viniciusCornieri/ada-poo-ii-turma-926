package br.com.ada.projeto.business;

import br.com.ada.projeto.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.persistence.AutorRepository;
import br.com.ada.projeto.persistence.Repository;

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

    public Autor consultarPorNome(String nome) {
        return repository.consultar(nome);
    }

    public boolean existeAutor(String nome) {
        return repository.consultar(nome) != null;
    }
}
