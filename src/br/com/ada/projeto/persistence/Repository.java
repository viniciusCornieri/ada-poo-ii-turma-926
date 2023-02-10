package br.com.ada.projeto.persistence;

import br.com.ada.ordenacao.Pessoa;
import br.com.ada.projeto.business.exception.RegistroJaExistenteException;

import java.util.List;

//Deixar esse repository e as suas implementações genéricas.
public interface Repository<T> {

    T salvar(T entidade);

    void atualizar(T entidade);

    boolean deletar(String id);

    T consultar(String id);

    List<T> listarTodos();
}
