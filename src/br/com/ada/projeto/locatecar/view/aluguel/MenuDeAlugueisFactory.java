package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.*;
import br.com.ada.projeto.locatecar.view.MenuComSubmenus;
import br.com.ada.projeto.locatecar.view.MenuFactory;
import br.com.ada.projeto.locatecar.view.MenuVoltar;
import br.com.ada.projeto.locatecar.view.veiculo.MenuAdicionarVeiculo;
import br.com.ada.projeto.locatecar.view.veiculo.MenuDeletarVeiculo;
import br.com.ada.projeto.locatecar.view.veiculo.MenuEditarVeiculo;
import br.com.ada.projeto.locatecar.view.veiculo.MenuListarVeiculos;

public class MenuDeAlugueisFactory implements MenuFactory {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuDeAlugueisFactory(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica, GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica, GerenciadorDeAluguel gerenciadorDeAluguel) {
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public MenuComSubmenus create() {
        MenuComSubmenus menuDeVeiculos = new MenuComSubmenus("Menu de " + gerenciadorDeAluguel.getDescricaoPluralDaEntidade());
        menuDeVeiculos.adicionarSubMenu(new MenuAlugarVeiculoParaPessoaFisica(gerenciadorDeVeiculo, gerenciadorDeClientePessoaFisica, gerenciadorDeAluguel));
        menuDeVeiculos.adicionarSubMenu(new MenuAlugarVeiculoParaPessoaJuridica(gerenciadorDeVeiculo, gerenciadorDeClientePessoaJuridica, gerenciadorDeAluguel));
        menuDeVeiculos.adicionarSubMenu(new MenuDevolverVeiculo(gerenciadorDeAluguel));
        menuDeVeiculos.adicionarSubMenu(new MenuListarAlugueis(gerenciadorDeAluguel));
        menuDeVeiculos.adicionarSubMenu(new MenuListarAlugueisEmAndamento(gerenciadorDeAluguel));
        menuDeVeiculos.adicionarSubMenu(new MenuVoltar());
        return menuDeVeiculos;
    }
}
