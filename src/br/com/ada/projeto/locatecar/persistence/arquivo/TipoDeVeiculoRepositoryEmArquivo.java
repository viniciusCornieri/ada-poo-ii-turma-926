package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.TipoVeiculoRepository;

public class TipoDeVeiculoRepositoryEmArquivo extends RepositorioEmArquivoGenerico<String, TipoVeiculo> implements TipoVeiculoRepository {

    public TipoDeVeiculoRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, TipoVeiculoRepository cache) {
        super(manipuladorDeArquivo, cache);
    }
}
