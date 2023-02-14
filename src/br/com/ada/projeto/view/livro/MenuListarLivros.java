package br.com.ada.projeto.view.livro;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.business.GerenciadorDeLivro;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.view.ConstanteDePaginacao;
import br.com.ada.projeto.view.MenuDePaginacao;
import br.com.ada.projeto.view.Submenu;

import java.util.List;

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
