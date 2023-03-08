package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarClientesPessoaFisica extends Submenu {
    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    public MenuListarClientesPessoaFisica(GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica) {
        super("Listar todos os " + gerenciadorDeClientePessoaFisica .getDescricaoPluralDaEntidade());
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
    }

    @Override
    public void acao() {
        MenuDePaginacao<ClientePessoaFisica> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeClientePessoaFisica.getDescricaoPluralDaEntidade(), gerenciadorDeClientePessoaFisica.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
