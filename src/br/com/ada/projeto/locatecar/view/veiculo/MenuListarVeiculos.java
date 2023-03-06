package br.com.ada.projeto.locatecar.view.veiculo;

import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarVeiculos extends Submenu {
    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    public MenuListarVeiculos(GerenciadorDeVeiculo gerenciadorDeVeiculo) {
        super("Listar todos os " + gerenciadorDeVeiculo .getDescricaoPluralDaEntidade());
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {
        MenuDePaginacao<Veiculo> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeVeiculo.getDescricaoPluralDaEntidade(), gerenciadorDeVeiculo.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
