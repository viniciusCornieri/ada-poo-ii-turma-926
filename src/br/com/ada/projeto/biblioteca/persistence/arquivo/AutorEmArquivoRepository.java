package br.com.ada.projeto.biblioteca.persistence.arquivo;

import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.persistence.AutorRepository;

import java.util.List;

public class AutorEmArquivoRepository extends RepositorioEmArquivoGenerico<Autor> implements AutorRepository {

    private final AutorRepository cache;

    public AutorEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, AutorRepository cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<Autor> consultarPorNacionalidade(String nacionalidade) {
        return cache.consultarPorNacionalidade(nacionalidade);
    }
}
