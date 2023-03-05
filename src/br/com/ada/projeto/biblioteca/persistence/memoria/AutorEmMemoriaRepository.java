package br.com.ada.projeto.biblioteca.persistence.memoria;

import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.persistence.AutorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AutorEmMemoriaRepository extends RepositorioEmMemoriaGenerico<Autor> implements AutorRepository {
    @Override
    public List<Autor> consultarPorNacionalidade(String nacionalidade) {
        return listarTodos().stream()
                .filter(autor -> autor.getNacionalidade().equals(nacionalidade))
                .collect(Collectors.toList());

//        List<Autor> autoresPorNacionalidade = new ArrayList<>();
//        for (Autor autor: listarTodos()) {
//            if (autor.getNacionalidade().equals(nacionalidade)) {
//                autoresPorNacionalidade.add(autor);
//            }
//        }
//        return autoresPorNacionalidade;
    }
}
