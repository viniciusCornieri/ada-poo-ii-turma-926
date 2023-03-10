package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;

import java.util.List;

public class VeiculoRepositoryEmArquivo extends RepositorioEmArquivoGenerico<String, Veiculo> implements VeiculoRepository {

    private final VeiculoRepository cache;
    public VeiculoRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, VeiculoRepository cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<Veiculo> listarVeiculosDisponiveis() {
        return cache.listarVeiculosDisponiveis();
    }
}
