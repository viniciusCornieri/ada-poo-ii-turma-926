package br.com.ada.projeto.locatecar.persistence;

import java.util.List;

public interface Repository<ID, T> {

    T salvar(T entidade);

    void atualizar(T entidade);

    boolean deletar(ID id);

    T consultar(ID id);

    List<T> listarTodos();
}
