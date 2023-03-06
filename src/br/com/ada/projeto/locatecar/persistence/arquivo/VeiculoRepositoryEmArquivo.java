package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;

public class VeiculoRepositoryEmArquivo extends RepositorioEmArquivoGenerico<String, Veiculo> implements VeiculoRepository {

    public VeiculoRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, VeiculoRepository cache) {
        super(manipuladorDeArquivo, cache);
    }
}
