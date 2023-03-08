package br.com.ada.projeto.locatecar.view;

import br.com.ada.projeto.locatecar.view.cliente.pessoafisica.MenuDeClientesPessoaFisicaFactory;
import br.com.ada.projeto.locatecar.view.veiculo.MenuDeVeiculosFactory;

public class MenuGeralFactory implements MenuFactory {
    private final MenuDeVeiculosFactory menuDeVeiculosFactory;
    private final MenuDeClientesPessoaFisicaFactory menuDeClientesPessoaFisicaFactory;

    public MenuGeralFactory(MenuDeVeiculosFactory menuDeVeiculosFactory, MenuDeClientesPessoaFisicaFactory menuDeClientesPessoaFisicaFactory) {
        this.menuDeVeiculosFactory = menuDeVeiculosFactory;
        this.menuDeClientesPessoaFisicaFactory = menuDeClientesPessoaFisicaFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();

        MenuComSubmenus menuDeVeiculos = menuDeVeiculosFactory.create();
        menuGeral.adicionarSubMenu(menuDeVeiculos);

        MenuComSubmenus menuDeClientesPessoaFisica = menuDeClientesPessoaFisicaFactory.create();
        menuGeral.adicionarSubMenu(menuDeClientesPessoaFisica);

        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}
