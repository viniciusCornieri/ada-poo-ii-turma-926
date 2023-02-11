package br.com.ada.projeto.view.autor;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.view.MenuComSubmenus;
import br.com.ada.projeto.view.MenuFactory;

public class MenuDeAutoresFactory implements MenuFactory {

    private final GerenciadorDeAutor gerenciadorDeAutor;

    public MenuDeAutoresFactory(GerenciadorDeAutor gerenciadorDeAutor) {
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeAutores = new MenuComSubmenus("Menu de Autores");
        menuDeAutores.adicionarSubMenu(new MenuAdicionarAutor(gerenciadorDeAutor));
        menuDeAutores.adicionarSubMenu(new MenuEditarAutor(gerenciadorDeAutor));
        menuDeAutores.adicionarSubMenu(new MenuDeletarAutor(gerenciadorDeAutor));
        menuDeAutores.adicionarSubMenu(new MenuListarAutores(gerenciadorDeAutor));
        return menuDeAutores;
    }
}
