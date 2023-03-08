package br.com.ada.projeto.locatecar.persistence.memoria;

import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;

import java.util.List;

public class ClienteRepositoryEmMemoria<T extends Cliente> extends RepositorioEmMemoriaGenerico<String, T> implements ClienteRepository<T> {


    @Override
    public List<T> buscarPorNome(String parteDoNome) {
        return listarTodos().stream()
                            .filter(c -> c.getNome().contains(parteDoNome))
                            .toList();
    }
}
