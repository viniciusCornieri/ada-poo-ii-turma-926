package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.ConstanteDePaginacao;
import br.com.ada.projeto.locatecar.view.MenuDePaginacao;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuListarClientesPessoaJuridicaPorNome extends Submenu {
    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    public MenuListarClientesPessoaJuridicaPorNome(GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica) {
        super("Listar " + gerenciadorDeClientePessoaJuridica .getDescricaoPluralDaEntidade() + " por parte do nome");
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("parte do nome fantasia");

        Paginavel<ClientePessoaJuridica> clientePessoaJuridicaPaginavel = gerenciadorDeClientePessoaJuridica.listarComPaginacaoPorNome(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA, nome);
        MenuDePaginacao<ClientePessoaJuridica> menuDePaginacao = new MenuDePaginacao<>(gerenciadorDeClientePessoaJuridica.getDescricaoPluralDaEntidade(), clientePessoaJuridicaPaginavel);
        menuDePaginacao.paginar();
    }
}
