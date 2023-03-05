package br.com.ada.projeto.biblioteca.persistence;

import br.com.ada.projeto.biblioteca.model.Autor;

import java.util.List;

public interface AutorRepository extends Repository<Autor> {

    List<Autor> consultarPorNacionalidade(String nacionalidade);
}
