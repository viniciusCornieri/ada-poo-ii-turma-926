package br.com.ada.projeto.locatecar.view.veiculo;

import br.com.ada.projeto.locatecar.business.GerenciadorDeTipoVeiculo;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.view.MenuComSubmenus;
import br.com.ada.projeto.locatecar.view.MenuFactory;
import br.com.ada.projeto.locatecar.view.MenuVoltar;

public class MenuDeVeiculosFactory implements MenuFactory {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;
    private final GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo;

    public MenuDeVeiculosFactory(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo) {
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de " + gerenciadorDeVeiculo.getDescricaoPluralDaEntidade());
        menuDeVeiculos.adicionarSubMenu(new MenuAdicionarVeiculo(gerenciadorDeVeiculo, gerenciadorDeTipoVeiculo));
        menuDeVeiculos.adicionarSubMenu(new MenuEditarVeiculo(gerenciadorDeVeiculo, gerenciadorDeTipoVeiculo));
        menuDeVeiculos.adicionarSubMenu(new MenuDeletarVeiculo(gerenciadorDeVeiculo));
        menuDeVeiculos.adicionarSubMenu(new MenuListarVeiculos(gerenciadorDeVeiculo));
        menuDeVeiculos.adicionarSubMenu(new MenuListarVeiculosDisponiveis(gerenciadorDeVeiculo));
        menuDeVeiculos.adicionarSubMenu(new MenuVoltar());
        return menuDeVeiculos;
    }
}
