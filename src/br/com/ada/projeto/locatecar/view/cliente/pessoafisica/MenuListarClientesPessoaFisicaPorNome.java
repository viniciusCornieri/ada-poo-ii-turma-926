package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarClientesPessoaFisicaPorNome extends Submenu {
    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    public MenuListarClientesPessoaFisicaPorNome(GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica) {
        super("Listar " + gerenciadorDeClientePessoaFisica .getDescricaoPluralDaEntidade() + " por parte do nome");
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("parte do nome");

        Paginavel<ClientePessoaFisica> clientePessoaFisicaPaginavel = gerenciadorDeClientePessoaFisica.listarComPaginacaoPorNome(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA, nome);
        MenuDePaginacao<ClientePessoaFisica> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeClientePessoaFisica.getDescricaoPluralDaEntidade(), clientePessoaFisicaPaginavel);
        menuDePaginacao.paginar();
    }
}
