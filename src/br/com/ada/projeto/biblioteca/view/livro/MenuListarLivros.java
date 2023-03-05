package br.com.ada.projeto.biblioteca.view.livro;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeLivro;
import br.com.ada.projeto.biblioteca.model.Livro;
import br.com.ada.projeto.biblioteca.view.ConstanteDePaginacao;
import br.com.ada.projeto.biblioteca.view.MenuDePaginacao;
import br.com.ada.projeto.biblioteca.view.Submenu;

public class MenuListarLivros extends Submenu {

    private final GerenciadorDeLivro gerenciadorDeLivro;


    public MenuListarLivros(GerenciadorDeLivro gerenciadorDeLivro) {
        super("Listar todos " + GerenciadorDeLivro.LIVRO_DESCRICAO_DA_CLASSE);
        this.gerenciadorDeLivro = gerenciadorDeLivro;
    }

    @Override
    public void acao() {
        MenuDePaginacao<Livro> menuDePaginacao = new MenuDePaginacao<>("Livros", gerenciadorDeLivro.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
