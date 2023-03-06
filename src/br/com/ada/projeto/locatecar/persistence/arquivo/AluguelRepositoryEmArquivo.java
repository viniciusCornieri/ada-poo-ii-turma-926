package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.persistence.AluguelRepository;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.memoria.RepositorioEmMemoriaGenerico;

import java.util.UUID;

public class AluguelRepositoryEmArquivo extends RepositorioEmArquivoGenerico<UUID, Aluguel> implements AluguelRepository {

    public AluguelRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, AluguelRepository cache) {
        super(manipuladorDeArquivo, cache);
    }
}
