package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;


public class MenuAlugarVeiculoParaPessoaJuridica extends Submenu {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuAlugarVeiculoParaPessoaJuridica(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica, GerenciadorDeAluguel gerenciadorDeAluguel) {
        super("Alugar %s para %s".formatted(gerenciadorDeVeiculo.getDescricaoDaEntidade(), gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade()));
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
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

        String cnpj = CapturadorDeEntrada.capturarString("o cnpj do cliente");

        Cliente cliente = gerenciadorDeClientePessoaJuridica.consultarPorCpf(cnpj);

        if (cliente == null) {
            System.out.printf("Não existe um %s com esse cnpj.%n", gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
            return;
        }

        Aluguel aluguel = gerenciadorDeAluguel.alugar(cliente, veiculo);

        System.out.println(gerenciadorDeAluguel.getDescricaoDaEntidade() + " criado com sucesso");
        System.out.println(aluguel);
    }
}
