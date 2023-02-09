package br.com.ada.projeto.persistence.memoria;

import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.AutorRepository;

import java.util.List;

public class AutorEmMemoriaRepository extends RepositorioEmMemoriaGenerico<Autor> implements AutorRepository {
    @Override
    public List<Autor> buscarPorNacionalidade(String nacionalidade) {
        return null;
    }
}
