package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.util.List;

public interface Repository {

    Pessoa salvar(Pessoa pessoa);

    void atualizar(Pessoa pessoa);

    boolean deletar(String cpf);

    Pessoa consultar(String cpf);

    List<Pessoa> listarTodos();
}
