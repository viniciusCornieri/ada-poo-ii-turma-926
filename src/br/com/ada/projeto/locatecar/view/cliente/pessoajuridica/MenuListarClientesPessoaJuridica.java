package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarClientesPessoaJuridica extends Submenu {
    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    public MenuListarClientesPessoaJuridica(GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica) {
        super("Listar todos os " + gerenciadorDeClientePessoaJuridica .getDescricaoPluralDaEntidade());
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
    }

    @Override
    public void acao() {
        MenuDePaginacao<ClientePessoaJuridica> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeClientePessoaJuridica.getDescricaoPluralDaEntidade(), gerenciadorDeClientePessoaJuridica.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
