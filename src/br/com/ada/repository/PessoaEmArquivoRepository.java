package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.arquivo.ManipuladorDeArquivo;
import br.com.ada.projeto.locatecar.persistence.arquivo.RepositorioEmArquivoGenerico;

public class PessoaEmArquivoRepository extends RepositorioEmArquivoGenerico<String, Pessoa> {

    public PessoaEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<String, Pessoa> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
