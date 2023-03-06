package br.com.ada.projeto.locatecar.persistence.memoria;

import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.persistence.AluguelRepository;

import java.util.UUID;

public class AluguelRepositoryEmMemoria extends RepositorioEmMemoriaGenerico<UUID, Aluguel> implements AluguelRepository {


}
