package br.com.ada.projeto.locatecar.persistence.memoria;

import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;

import java.util.List;

public class VeiculoRepositoryEmMemoria extends RepositorioEmMemoriaGenerico<String, Veiculo> implements VeiculoRepository {


    @Override
    public List<Veiculo> listarVeiculosDisponiveis() {
        return listarTodos().stream().filter(Veiculo::isDisponivel).toList();
    }
}
