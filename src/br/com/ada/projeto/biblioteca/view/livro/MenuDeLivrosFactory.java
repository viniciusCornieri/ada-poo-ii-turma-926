package br.com.ada.projeto.biblioteca.view.livro;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.biblioteca.business.GerenciadorDeLivro;
import br.com.ada.projeto.biblioteca.view.MenuComSubmenus;
import br.com.ada.projeto.biblioteca.view.MenuFactory;

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
