package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.util.List;

import static br.com.ada.projeto.locatecar.view.CapturadorDeEntrada.capturarStringDentreAsPossiveis;


public class MenuAdicionarClientePessoaFisica extends Submenu {

    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    public MenuAdicionarClientePessoaFisica(GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica) {
        super("Adicionar " + gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
    }

    @Override
    public void acao() {
        String cpf = CapturadorDeEntrada.capturarString("o cpf");

        if (gerenciadorDeClientePessoaFisica.existe(cpf)) {
            System.out.printf("Já existe um %s com esse cpf.%n", gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
            return;
        }

        String nome = CapturadorDeEntrada.capturarString("o nome completo");

        ClientePessoaFisica clienteAdicionado = gerenciadorDeClientePessoaFisica.adicionar(cpf, nome);

        System.out.println(gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(clienteAdicionado);
    }
}
