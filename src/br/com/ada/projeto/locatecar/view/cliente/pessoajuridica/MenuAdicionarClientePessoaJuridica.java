package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;


public class MenuAdicionarClientePessoaJuridica extends Submenu {

    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    public MenuAdicionarClientePessoaJuridica(GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica) {
        super("Adicionar " + gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
    }

    @Override
    public void acao() {
        String cnpj = CapturadorDeEntrada.capturarString("o cnpj");

        if (gerenciadorDeClientePessoaJuridica.existe(cnpj)) {
            System.out.printf("Já existe um %s com esse cnpj.%n", gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome fantasia");

        ClientePessoaJuridica clienteAdicionado = gerenciadorDeClientePessoaJuridica.adicionar(cnpj, nome);

        System.out.println(gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(clienteAdicionado);
    }
}
