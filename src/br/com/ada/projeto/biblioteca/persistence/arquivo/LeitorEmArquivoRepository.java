package br.com.ada.projeto.biblioteca.persistence.arquivo;

import br.com.ada.projeto.biblioteca.model.Leitor;
import br.com.ada.projeto.biblioteca.persistence.Repository;

public class LeitorEmArquivoRepository extends RepositorioEmArquivoGenerico<Leitor> {
    public LeitorEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Leitor> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
