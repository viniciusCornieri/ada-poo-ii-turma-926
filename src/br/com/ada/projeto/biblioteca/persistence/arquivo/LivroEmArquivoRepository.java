package br.com.ada.projeto.biblioteca.persistence.arquivo;

import br.com.ada.projeto.biblioteca.model.Livro;
import br.com.ada.projeto.biblioteca.persistence.Repository;

public class LivroEmArquivoRepository extends RepositorioEmArquivoGenerico<Livro> {
    public LivroEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Livro> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
