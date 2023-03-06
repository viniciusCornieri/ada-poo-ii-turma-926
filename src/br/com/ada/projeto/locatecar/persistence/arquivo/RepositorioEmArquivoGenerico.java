package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Entidade;
import br.com.ada.projeto.locatecar.persistence.Repository;

import java.util.List;

public class RepositorioEmArquivoGenerico<ID, T extends Entidade> implements Repository<ID, T> {

    private final Repository<ID, T> cache;

    private final ManipuladorDeArquivo manipuladorDeArquivo;

    public RepositorioEmArquivoGenerico(ManipuladorDeArquivo manipuladorDeArquivo, Repository<ID, T> cache) {
        this.manipuladorDeArquivo = manipuladorDeArquivo;
        this.cache = cache;

        carregarDadosNoCache(manipuladorDeArquivo);
    }

    private void carregarDadosNoCache(ManipuladorDeArquivo manipuladorDeArquivo) {
        List<T> dadosIniciais = (List<T>) manipuladorDeArquivo.lerDoArquivo();
        System.out.println("Dados iniciais: " + dadosIniciais);
        for (T dado: dadosIniciais) {
            this.cache.salvar(dado);
        }
    }

    @Override
    public T salvar(T entidade) {
        T entidadeSalva = this.cache.salvar(entidade);
        persistir();
        return entidadeSalva;
    }

    @Override
    public void atualizar(T entidade) {
        this.cache.atualizar(entidade);
        persistir();
    }

    @Override
    public boolean deletar(ID id) {
        boolean foiDeletado = this.cache.deletar(id);
        if (foiDeletado) {
            persistir();
        }
        return foiDeletado;
    }

    @Override
    public T consultar(ID id) {
        return this.cache.consultar(id);
    }

    @Override
    public List<T> listarTodos() {
        return this.cache.listarTodos();
    }

    private void persistir() {
        manipuladorDeArquivo.escreverNoArquivo(listarTodos());
    }
}
