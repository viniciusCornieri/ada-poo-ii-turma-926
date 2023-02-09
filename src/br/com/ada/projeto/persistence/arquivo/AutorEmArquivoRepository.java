package br.com.ada.projeto.persistence.arquivo;

import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.AutorRepository;
import br.com.ada.projeto.persistence.Repository;

import java.util.List;

public class AutorEmArquivoRepository extends RepositorioEmArquivoGenerico<Autor> implements AutorRepository {

    private final AutorRepository cache;

    public AutorEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, AutorRepository cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<Autor> buscarPorNacionalidade(String nacionalidade) {
        return cache.buscarPorNacionalidade(nacionalidade);
    }
}
