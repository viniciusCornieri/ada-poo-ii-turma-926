package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.util.List;

public class PessoaEmMemoriaRepository extends RepositorioEmMemoriaGenerico<Pessoa> {

    public PessoaEmMemoriaRepository(List<Pessoa> dadosIniciais) {
        super(dadosIniciais);
    }

    public PessoaEmMemoriaRepository() {
        super();
    }

}
