package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.util.List;

public class PessoaEmArquivoRepository extends RepositorioEmArquivoGenerico<Pessoa> {
    public PessoaEmArquivoRepository() {
        super("dados_pessoa.txt");
    }
}
