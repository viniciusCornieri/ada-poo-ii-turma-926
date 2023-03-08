package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;


public class MenuEditarClientePessoaFisica extends Submenu {

    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    public MenuEditarClientePessoaFisica(GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica) {
        super("Editar " + gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
    }

    @Override
    public void acao() {
        String cpf = CapturadorDeEntrada.capturarString("o cpf");

        ClientePessoaFisica cliente = gerenciadorDeClientePessoaFisica.consultarPorCpf(cpf);
        boolean naoExisteCliente = cliente == null;
        if (naoExisteCliente) {
            System.out.printf("Não existe um %s com esse cnpj.%n", gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome completo");

        ClientePessoaFisica clienteAlterado = gerenciadorDeClientePessoaFisica.editar(cpf, nome);

        System.out.println(gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(clienteAlterado);
    }
}
