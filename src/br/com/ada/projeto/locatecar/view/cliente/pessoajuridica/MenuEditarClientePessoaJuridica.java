package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;


public class MenuEditarClientePessoaJuridica extends Submenu {

    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    public MenuEditarClientePessoaJuridica(GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica) {
        super("Editar " + gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
    }

    @Override
    public void acao() {
        String cnpj = CapturadorDeEntrada.capturarString("o cnpj");

        ClientePessoaJuridica cliente = gerenciadorDeClientePessoaJuridica.consultarPorCpf(cnpj);
        boolean naoExisteCliente = cliente == null;
        if (naoExisteCliente) {
            System.out.printf("Não existe um %s com esse cnpj.%n", gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome fantasia");

        ClientePessoaJuridica clienteAlterado = gerenciadorDeClientePessoaJuridica.editar(cnpj, nome);

        System.out.println(gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(clienteAlterado);
    }
}
