package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;
import br.com.ada.projeto.persistence.Repository;
import br.com.ada.projeto.persistence.arquivo.ManipuladorDeArquivo;
import br.com.ada.projeto.persistence.arquivo.RepositorioEmArquivoGenerico;

public class PessoaEmArquivoRepository extends RepositorioEmArquivoGenerico<Pessoa> {

    public PessoaEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Pessoa> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
