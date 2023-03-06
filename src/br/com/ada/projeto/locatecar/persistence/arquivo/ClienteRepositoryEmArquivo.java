package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;
import br.com.ada.projeto.locatecar.persistence.Repository;

import java.util.List;

public class ClienteRepositoryEmArquivo extends RepositorioEmArquivoGenerico<String, Cliente> implements ClienteRepository {

    private final ClienteRepository cache;

    public ClienteRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, ClienteRepository cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<Cliente> buscarPorNome(String parteDoNome) {
        return cache.buscarPorNome(parteDoNome);
    }
}
