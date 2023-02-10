package br.com.ada.projeto.persistence;

import br.com.ada.projeto.model.Autor;

import java.util.List;

public interface AutorRepository extends Repository<Autor> {

    List<Autor> consultarPorNacionalidade(String nacionalidade);
}
