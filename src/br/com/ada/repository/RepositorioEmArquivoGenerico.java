package br.com.ada.repository;

import java.util.List;

public class RepositorioEmArquivoGenerico<T extends Entidade> implements Repository<T> {

    private final RepositorioEmMemoriaGenerico<T> repositorioEmMemoria;

    private final String arquivo;

    public RepositorioEmArquivoGenerico(String arquivo) {
        this.arquivo = arquivo;
        List<T> dadosIniciais = (List<T>) ManipuladorDeArquivo.lerDoArquivo(arquivo);
        System.out.println("Dados iniciais: " + dadosIniciais);
        this.repositorioEmMemoria = new RepositorioEmMemoriaGenerico<>(dadosIniciais);
    }
    @Override
    public T salvar(T entidade) {
        T entidadeSalva = this.repositorioEmMemoria.salvar(entidade);
        persistir();
        return entidadeSalva;
    }

    @Override
    public void atualizar(T entidade) {
        this.repositorioEmMemoria.atualizar(entidade);
        persistir();
    }

    @Override
    public boolean deletar(String id) {
        boolean foiDeletado = this.repositorioEmMemoria.deletar(id);
        if (foiDeletado) {
            persistir();
        }
        return foiDeletado;
    }

    @Override
    public T consultar(String id) {
        return this.repositorioEmMemoria.consultar(id);
    }

    @Override
    public List<T> listarTodos() {
        return this.repositorioEmMemoria.listarTodos();
    }

    private void persistir() {
        ManipuladorDeArquivo.escreverEmArquivo(listarTodos(), arquivo);
    }
}
