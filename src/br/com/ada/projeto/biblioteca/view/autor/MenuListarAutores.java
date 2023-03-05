package br.com.ada.projeto.biblioteca.view.autor;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.view.ConstanteDePaginacao;
import br.com.ada.projeto.biblioteca.view.MenuDePaginacao;
import br.com.ada.projeto.biblioteca.view.Submenu;

public class MenuListarAutores extends Submenu {
    private final GerenciadorDeAutor gerenciadorDeAutor;

    public MenuListarAutores(GerenciadorDeAutor gerenciadorDeAutor) {
        super("Listar todos " + GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE);
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        MenuDePaginacao<Autor> menuDePaginacao = new MenuDePaginacao<>("Autores", gerenciadorDeAutor.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
