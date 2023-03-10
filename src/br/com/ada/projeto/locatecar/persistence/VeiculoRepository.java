package br.com.ada.projeto.locatecar.persistence;

import br.com.ada.projeto.locatecar.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends Repository<String, Veiculo> {

    List<Veiculo> listarVeiculosDisponiveis();

}
