package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;
import br.com.ada.projeto.locatecar.persistence.Repository;

import java.util.List;

public class ClienteRepositoryEmArquivo<T extends Cliente> extends RepositorioEmArquivoGenerico<String, T> implements ClienteRepository<T> {

    private final ClienteRepository<T> cache;

    public ClienteRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, ClienteRepository<T> cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<T> buscarPorNome(String parteDoNome) {
        return cache.buscarPorNome(parteDoNome);
    }
}
