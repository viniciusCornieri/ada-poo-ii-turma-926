package br.com.ada.projeto.biblioteca.view;

import br.com.ada.projeto.biblioteca.view.autor.MenuDeAutoresFactory;
import br.com.ada.projeto.biblioteca.view.livro.MenuDeLivrosFactory;

public class MenuGeralFactory implements MenuFactory {

    private final MenuDeAutoresFactory menuDeAutoresFactory;
    private final MenuDeLivrosFactory menuDeLivrosFactory;

    public MenuGeralFactory(MenuDeAutoresFactory menuDeAutoresFactory, MenuDeLivrosFactory menuDeLivrosFactory) {
        this.menuDeAutoresFactory = menuDeAutoresFactory;
        this.menuDeLivrosFactory = menuDeLivrosFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();
        MenuComSubmenus menuDeAutores = menuDeAutoresFactory.create();

        menuGeral.adicionarSubMenu(menuDeAutores);
        menuGeral.adicionarSubMenu(menuDeLivrosFactory.create());
        menuGeral.adicionarSubMenu(new MenuComSubmenus("Menu de Empréstimos"));
        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}
