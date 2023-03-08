package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.view.MenuComSubmenus;
import br.com.ada.projeto.locatecar.view.MenuFactory;
import br.com.ada.projeto.locatecar.view.MenuVoltar;

public class MenuDeClientesPessoaFisicaFactory implements MenuFactory {

    private final GerenciadorDeClientePessoaFisica gerenciadorClientePessoaFisica;

    public MenuDeClientesPessoaFisicaFactory(GerenciadorDeClientePessoaFisica gerenciadorClientePessoaFisica) {
        this.gerenciadorClientePessoaFisica = gerenciadorClientePessoaFisica;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de " + gerenciadorClientePessoaFisica.getDescricaoPluralDaEntidade());
        menuDeVeiculos.adicionarSubMenu(new MenuAdicionarClientePessoaFisica(gerenciadorClientePessoaFisica));
        menuDeVeiculos.adicionarSubMenu(new MenuEditarClientePessoaFisica(gerenciadorClientePessoaFisica));
        menuDeVeiculos.adicionarSubMenu(new MenuDeletarClientePessoaFisica(gerenciadorClientePessoaFisica));
        menuDeVeiculos.adicionarSubMenu(new MenuListarClientesPessoaFisica(gerenciadorClientePessoaFisica));
        menuDeVeiculos.adicionarSubMenu(new MenuListarClientesPessoaFisicaPorNome(gerenciadorClientePessoaFisica));
        menuDeVeiculos.adicionarSubMenu(new MenuVoltar());
        return menuDeVeiculos;
    }
}
