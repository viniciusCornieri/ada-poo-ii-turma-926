package br.com.ada.projeto.persistence.arquivo;

import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.Repository;

public class LivroEmArquivoRepository extends RepositorioEmArquivoGenerico<Livro> {
    public LivroEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Livro> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
