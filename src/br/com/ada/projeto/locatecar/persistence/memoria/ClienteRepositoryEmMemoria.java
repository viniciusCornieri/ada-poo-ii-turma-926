package br.com.ada.projeto.locatecar.persistence.memoria;

import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;

import java.util.List;

public class ClienteRepositoryEmMemoria extends RepositorioEmMemoriaGenerico<String, Cliente> implements ClienteRepository {


    @Override
    public List<Cliente> buscarPorNome(String parteDoNome) {
        return listarTodos().stream()
                            .filter(c -> c.getNome().contains(parteDoNome))
                            .toList();
    }
}
