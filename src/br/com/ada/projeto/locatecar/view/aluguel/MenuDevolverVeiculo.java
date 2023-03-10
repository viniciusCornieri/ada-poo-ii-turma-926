package br.com.ada.projeto.locatecar.view.aluguel;

import br.com.ada.projeto.locatecar.business.GerenciadorDeAluguel;
import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        Aluguel aluguel = gerenciadorDeAluguel.consultarPorId(id);
        if (aluguel == null) {
            System.out.printf("Não existe um %s com esse id.%n", gerenciadorDeAluguel.getDescricaoDaEntidade());
            return;
        }

        LocalDateTime dataDevolucao = capturarDataDeDevolucao();

        if (dataDevolucao == null) {
            return;
        }

        Aluguel aluguelDevolvido = gerenciadorDeAluguel.devolver(id, dataDevolucao);
        System.out.println(gerenciadorDeAluguel.getDescricaoDaEntidade() + " devolvido com sucesso");
        System.out.println(aluguelDevolvido);
        exibirSeparador();
        System.out.printf("Aluguel referente a %s diárias%n", aluguelDevolvido.getDiarias());
        System.out.println("Valor das diárias: R$ " + aluguelDevolvido.getValorBruto());
        System.out.println("Valor do desconto: R$ " + aluguelDevolvido.getDesconto());
        System.out.println("Valor do total: R$ " + aluguelDevolvido.getValorLiquido());
        exibirSeparador();
    }

    private static LocalDateTime capturarDataDeDevolucao() {
        String dataDevolucaoStr = CapturadorDeEntrada.capturarString("a data de devolução[yyyy-MM-dd HH:mm:ss]");
        try {
        LocalDateTime dataDevolucao = LocalDateTime.parse(dataDevolucaoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return dataDevolucao;
        } catch (Exception e) {
            System.out.println("Entrada inválida não foi possível reconhecer a data de devolução, informar no padrão yyyy-MM-dd HH:mm:ss");
            return null;
        }
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
