package br.com.ada.projeto.locatecar.persistence.memoria;

import br.com.ada.projeto.locatecar.model.Entidade;
import br.com.ada.projeto.locatecar.persistence.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmMemoriaGenerico<ID, T extends Entidade<ID>> implements Repository<ID, T> {

    private final List<T> dados;

    public RepositorioEmMemoriaGenerico() {
        this.dados = new ArrayList<>();
    }

    @Override
    public T salvar(T entidade) {
        if (existe(entidade)) {
            throw new IllegalArgumentException("Já existe uma entidade com esse id cadastrado");
        }
        dados.add(entidade);
        return entidade;
    }

    private boolean existe(T entidade) {
        ID id = entidade.getId();
        return existe(id);
    }

    private boolean existe(ID id) {
        return consultar(id) != null;
    }

    @Override
    public void atualizar(T entidade) {
        if (!existe(entidade)) {
            throw new IllegalArgumentException("Não existe uma entidade com esse ID cadastrado para atualizar");
        }

        deletar(entidade.getId());
        salvar(entidade);
    }

    @Override
    public boolean deletar(ID id) {
        if (existe(id)) {
            T consultar = consultar(id);
            dados.remove(consultar);
            return true;
        }
        return false;
    }

    @Override
    public T consultar(ID id) {
        for (T entidade: dados) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dados);
    }
}
