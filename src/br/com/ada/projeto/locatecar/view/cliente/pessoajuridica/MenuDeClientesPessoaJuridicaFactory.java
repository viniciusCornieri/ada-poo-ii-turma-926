package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.MenuComSubmenus;
import br.com.ada.projeto.locatecar.view.MenuFactory;
import br.com.ada.projeto.locatecar.view.MenuVoltar;

public class MenuDeClientesPessoaJuridicaFactory implements MenuFactory {

    private final GerenciadorDeClientePessoaJuridica gerenciadorClientePessoaJuridica;

    public MenuDeClientesPessoaJuridicaFactory(GerenciadorDeClientePessoaJuridica gerenciadorClientePessoaJuridica) {
        this.gerenciadorClientePessoaJuridica = gerenciadorClientePessoaJuridica;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de " + gerenciadorClientePessoaJuridica.getDescricaoPluralDaEntidade());
        menuDeVeiculos.adicionarSubMenu(new MenuAdicionarClientePessoaJuridica(gerenciadorClientePessoaJuridica));
        menuDeVeiculos.adicionarSubMenu(new MenuEditarClientePessoaJuridica(gerenciadorClientePessoaJuridica));
        menuDeVeiculos.adicionarSubMenu(new MenuDeletarClienteJuridica(gerenciadorClientePessoaJuridica));
        menuDeVeiculos.adicionarSubMenu(new MenuListarClientesPessoaJuridica(gerenciadorClientePessoaJuridica));
        menuDeVeiculos.adicionarSubMenu(new MenuListarClientesPessoaJuridicaPorNome(gerenciadorClientePessoaJuridica));
        menuDeVeiculos.adicionarSubMenu(new MenuVoltar());
        return menuDeVeiculos;
    }
}
