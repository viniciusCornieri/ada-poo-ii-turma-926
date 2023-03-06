package br.com.ada.projeto.locatecar.persistence;

import br.com.ada.projeto.locatecar.model.Cliente;

import java.util.List;

public interface ClienteRepository extends Repository<String, Cliente> {

    List<Cliente> buscarPorNome(String parteDoNome);

}
