package br.com.ada.projeto.view.livro;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.business.GerenciadorDeLivro;
import br.com.ada.projeto.view.MenuComSubmenus;
import br.com.ada.projeto.view.MenuFactory;

public class MenuDeLivrosFactory implements MenuFactory {

    private final GerenciadorDeAutor gerenciadorDeAutor;
    private final GerenciadorDeLivro gerenciadorDeLivro;

    public MenuDeLivrosFactory(GerenciadorDeAutor gerenciadorDeAutor, GerenciadorDeLivro gerenciadorDeLivro) {
        this.gerenciadorDeAutor = gerenciadorDeAutor;
        this.gerenciadorDeLivro = gerenciadorDeLivro;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeLivros = new MenuComSubmenus("Menu de Livros");
        menuDeLivros.adicionarSubMenu(new MenuAdicionarLivro(gerenciadorDeLivro, gerenciadorDeAutor));
        menuDeLivros.adicionarSubMenu(new MenuListarLivros(gerenciadorDeLivro));
        return menuDeLivros;
    }
}
