package br.com.ada.repository;

import br.com.ada.ordenacao.Livro;

public class LivroEmArquivoRepository extends RepositorioEmArquivoGenerico<Livro> {
    public LivroEmArquivoRepository() {
        super("livros.txt");
    }
}
