package br.com.ada.projeto.locatecar.persistence;

import br.com.ada.projeto.locatecar.model.Cliente;

import java.util.List;

public interface ClienteRepository<T extends Cliente> extends Repository<String, T> {

    List<T> buscarPorNome(String parteDoNome);

}
