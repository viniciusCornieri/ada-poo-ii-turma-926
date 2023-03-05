package br.com.ada.projeto.biblioteca.view.livro;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.biblioteca.business.GerenciadorDeLivro;
import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.model.Livro;
import br.com.ada.projeto.biblioteca.view.CapturadorDeEntrada;
import br.com.ada.projeto.biblioteca.view.Submenu;

public class MenuAdicionarLivro extends Submenu {

    private final GerenciadorDeLivro gerenciadorDeLivro;
    private final GerenciadorDeAutor gerenciadorDeAutor;


    public MenuAdicionarLivro(GerenciadorDeLivro gerenciadorDeLivro, GerenciadorDeAutor gerenciadorDeAutor) {
        super("Adicionar " + GerenciadorDeLivro.LIVRO_DESCRICAO_DA_CLASSE);
        this.gerenciadorDeLivro = gerenciadorDeLivro;
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        String isbn = CapturadorDeEntrada.capturarString("o isbn");

        if (gerenciadorDeLivro.existeLivro(isbn)) {
            System.out.println("Já existe um livro com esse isbn");
            return;
        }

        String nomeDoAutor = CapturadorDeEntrada.capturarString("o nome do autor");

        Autor autor = gerenciadorDeAutor.consultarPorNome(nomeDoAutor);
        if (autor == null) {
            System.out.println("Não foi encontrado autor com esse nome!");
            return;
        }

        String titulo = CapturadorDeEntrada.capturarString("o titulo");

        Livro livroAdicionado = gerenciadorDeLivro.adicionarLivro(titulo, isbn, autor);

        System.out.println(GerenciadorDeLivro.LIVRO_DESCRICAO_DA_CLASSE + " adicionado com sucesso");
        System.out.println(livroAdicionado);
    }
}
