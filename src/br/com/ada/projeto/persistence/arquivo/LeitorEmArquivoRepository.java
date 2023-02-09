package br.com.ada.projeto.persistence.arquivo;

import br.com.ada.projeto.model.Leitor;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.Repository;

public class LeitorEmArquivoRepository extends RepositorioEmArquivoGenerico<Leitor> {
    public LeitorEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Leitor> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
