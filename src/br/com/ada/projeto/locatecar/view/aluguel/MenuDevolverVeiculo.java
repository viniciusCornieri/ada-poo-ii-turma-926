package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.util.UUID;


public class MenuDevolverVeiculo extends Submenu {

    private final GerenciadorDeAluguel gerenciadorDeAluguel;

    public MenuDevolverVeiculo(GerenciadorDeAluguel gerenciadorDeAluguel) {
        super("Devolver Veículo");
        this.gerenciadorDeAluguel = gerenciadorDeAluguel;
    }

    @Override
    public void acao() {
        UUID id = capturaId();

        if (id == null) {
            return;
        }

        if (!gerenciadorDeAluguel.existe(id)) {
            System.out.printf("Não existe um %s com esse id.%n", gerenciadorDeAluguel.getDescricaoDaEntidade());
            return;
        }

        Aluguel aluguel = gerenciadorDeAluguel.devolver(id);
        System.out.println(gerenciadorDeAluguel.getDescricaoDaEntidade() + " devolvido com sucesso");
        System.out.println(aluguel);
        exibirSeparador();
        System.out.printf("Aluguel referente a %s diárias%n", aluguel.getDiarias());
        System.out.println("Valor das diárias: R$" + aluguel.getValorBruto());
        System.out.println("Valor do desconto: R$" + aluguel.getDesconto());
        System.out.println("Valor do total: R$" + aluguel.getValorLiquido());
        exibirSeparador();
    }

    private static UUID capturaId() {
        String id = CapturadorDeEntrada.capturarString("o identificador do aluguel");
        try {
            UUID uuid = UUID.fromString(id);
            return uuid;
        } catch (Exception e) {
            System.out.println("Id informado inválido.");
            return null;
        }
    }
}
