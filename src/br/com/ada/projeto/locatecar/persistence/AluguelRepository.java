package br.com.ada.projeto.locatecar.persistence;

import br.com.ada.projeto.locatecar.model.Aluguel;

import java.util.List;
import java.util.UUID;

public interface AluguelRepository extends Repository<UUID, Aluguel> {

    List<Aluguel> listarAlugueisEmAndamento();

}
