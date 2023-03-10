package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.*;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.util.List;

import static br.com.ada.projeto.locatecar.view.CapturadorDeEntrada.capturarStringDentreAsPossiveis;


public class MenuAlugarVeiculoParaPessoaFisica extends Submenu {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuAlugarVeiculoParaPessoaFisica(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica, GerenciadorDeAluguel gerenciadorDeAluguel) {
        super("Alugar %s para %s".formatted(gerenciadorDeVeiculo.getDescricaoDaEntidade(), gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade()));
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a placa do veiculo");

        Veiculo veiculo = gerenciadorDeVeiculo.consultarPorPlaca(placa);
        if (veiculo == null) {
            System.out.printf("Não existe um %s com essa placa.%n", gerenciadorDeVeiculo.getDescricaoDaEntidade());
            return;
        }

        if (!veiculo.isDisponivel()) {
            System.out.printf("O %s com essa placa não está disponível.%n", gerenciadorDeVeiculo.getDescricaoDaEntidade());
            return;
        }

        String cpf = CapturadorDeEntrada.capturarString("o cpf do cliente");

        Cliente cliente = gerenciadorDeClientePessoaFisica.consultarPorCpf(cpf);

        if (cliente == null) {
            System.out.printf("Não existe um %s com esse cpf.%n", gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
            return;
        }

        Aluguel aluguel = gerenciadorDeAluguel.alugar(cliente, veiculo);

        System.out.println(gerenciadorDeAluguel.getDescricaoDaEntidade() + " criado com sucesso");
        System.out.println(aluguel);
    }
}
