package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarAlugueisEmAndamento extends Submenu {
    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuListarAlugueisEmAndamento(GerenciadorDeAluguel gerenciadorDeAluguel) {
        super("Listar todos os " + gerenciadorDeAluguel .getDescricaoPluralDaEntidade() + " em andamento");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        MenuDePaginacao<Aluguel> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeAluguel.getDescricaoPluralDaEntidade(), gerenciadorDeAluguel.listarEmAndamentoComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
