package br.com.ada.projeto.locatecar.view;

import br.com.ada.projeto.locatecar.view.cliente.pessoafisica.MenuDeClientesPessoaFisicaFactory;
import br.com.ada.projeto.locatecar.view.cliente.pessoajuridica.MenuDeClientesPessoaJuridicaFactory;
import br.com.ada.projeto.locatecar.view.veiculo.MenuDeVeiculosFactory;

public class MenuGeralFactory implements MenuFactory {
    private final MenuDeVeiculosFactory menuDeVeiculosFactory;
    private final MenuDeClientesPessoaFisicaFactory menuDeClientesPessoaFisicaFactory;
    private final MenuDeClientesPessoaJuridicaFactory menuDeClientesPessoaJuridicaFactory;

    public MenuGeralFactory(MenuDeVeiculosFactory menuDeVeiculosFactory, MenuDeClientesPessoaFisicaFactory menuDeClientesPessoaFisicaFactory, MenuDeClientesPessoaJuridicaFactory menuDeClientesPessoaJuridicaFactory) {
        this.menuDeVeiculosFactory = menuDeVeiculosFactory;
        this.menuDeClientesPessoaFisicaFactory = menuDeClientesPessoaFisicaFactory;
        this.menuDeClientesPessoaJuridicaFactory = menuDeClientesPessoaJuridicaFactory;
    }

    @Override
    public MenuComSubmenus create() {
        MenuGeral menuGeral = new MenuGeral();

        MenuComSubmenus menuDeVeiculos = menuDeVeiculosFactory.create();
        menuGeral.adicionarSubMenu(menuDeVeiculos);

        MenuComSubmenus menuDeClientesPessoaFisica = menuDeClientesPessoaFisicaFactory.create();
        menuGeral.adicionarSubMenu(menuDeClientesPessoaFisica);

        MenuComSubmenus menuDeClientesPessoaJuridica = menuDeClientesPessoaJuridicaFactory.create();
        menuGeral.adicionarSubMenu(menuDeClientesPessoaJuridica);

        menuGeral.adicionarSubMenu(new MenuEncerrar());
        return menuGeral;
    }
}
