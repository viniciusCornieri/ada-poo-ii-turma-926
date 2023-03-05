package br.com.ada.projeto.biblioteca.persistence.memoria;

import br.com.ada.projeto.biblioteca.model.Entidade;
import br.com.ada.projeto.biblioteca.persistence.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmMemoriaGenerico<T extends Entidade> implements Repository<T> {

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
        String id = entidade.getId();
        return existe(id);
    }

    private boolean existe(String id) {
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
    public boolean deletar(String id) {
        if (existe(id)) {
            T consultar = consultar(id);
            dados.remove(consultar);
            return true;
        }
        return false;
    }

    @Override
    public T consultar(String id) {
        for (T entidade: dados) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;

//        Optional<T> entidade = dados.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst();
//        return entidade.orElse(null);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dados);
    }
}
