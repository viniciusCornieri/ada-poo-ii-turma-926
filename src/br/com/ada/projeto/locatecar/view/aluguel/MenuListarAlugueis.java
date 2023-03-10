package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarAlugueis extends Submenu {
    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuListarAlugueis(GerenciadorDeAluguel gerenciadorDeAluguel) {
        super("Listar todos os " + gerenciadorDeAluguel .getDescricaoPluralDaEntidade());
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        MenuDePaginacao<Aluguel> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeAluguel.getDescricaoPluralDaEntidade(), gerenciadorDeAluguel.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
