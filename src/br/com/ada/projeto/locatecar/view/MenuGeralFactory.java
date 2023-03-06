package br.com.ada.projeto.locatecar.view;

import br.com.ada.projeto.locatecar.view.veiculo.MenuDeVeiculosFactory;

public class MenuGeralFactory implements MenuFactory {
    private final MenuDeVeiculosFactory menuDeVeiculosFactory;

    public MenuGeralFactory(MenuDeVeiculosFactory menuDeVeiculosFactory) {
        this.menuDeVeiculosFactory = menuDeVeiculosFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();
        MenuComSubmenus menuDeVeiculos = menuDeVeiculosFactory.create();

        menuGeral.adicionarSubMenu(menuDeVeiculos);
        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}
