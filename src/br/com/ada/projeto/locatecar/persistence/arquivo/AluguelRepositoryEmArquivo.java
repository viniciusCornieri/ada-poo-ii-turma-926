package br.com.ada.projeto.locatecar.persistence.arquivo;

import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.persistence.AluguelRepository;
import br.com.ada.projeto.locatecar.persistence.Repository;
import br.com.ada.projeto.locatecar.persistence.memoria.RepositorioEmMemoriaGenerico;

import java.util.List;
import java.util.UUID;

public class AluguelRepositoryEmArquivo extends RepositorioEmArquivoGenerico<UUID, Aluguel> implements AluguelRepository {

    private final AluguelRepository cache;

    public AluguelRepositoryEmArquivo(ManipuladorDeArquivo manipuladorDeArquivo, AluguelRepository cache) {
        super(manipuladorDeArquivo, cache);
        this.cache = cache;
    }

    @Override
    public List<Aluguel> listarAlugueisEmAndamento() {
        return cache.listarAlugueisEmAndamento();
    }
}
