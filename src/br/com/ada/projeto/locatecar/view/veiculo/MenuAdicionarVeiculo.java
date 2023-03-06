package br.com.ada.projeto.locatecar.view.veiculo;

import br.com.ada.projeto.locatecar.business.GerenciadorDeTipoVeiculo;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.util.List;

import static br.com.ada.projeto.locatecar.view.CapturadorDeEntrada.capturarStringDentreAsPossiveis;


public class MenuAdicionarVeiculo extends Submenu {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;
    private final GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo;

    public MenuAdicionarVeiculo(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo) {
        super("Adicionar " + gerenciadorDeVeiculo.getDescricaoDaEntidade());
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a placa do veiculo");

        if (gerenciadorDeVeiculo.existe(placa)) {
            System.out.printf("Já existe um %s com essa placa.%n", gerenciadorDeVeiculo.getDescricaoDaEntidade());
            return;
        }

        String modelo = CapturadorDeEntrada.capturarString("o modelo");

        List<String> tiposDeVeiculoPossiveis = gerenciadorDeTipoVeiculo.listarTodos().stream().map(TipoVeiculo::getId).toList();

        String mensagemDoCampoTipoVeiculo = "o %s.".formatted(gerenciadorDeTipoVeiculo.getDescricaoDaEntidade());
        String tipoVeiculoSelecionado = capturarStringDentreAsPossiveis(mensagemDoCampoTipoVeiculo, tiposDeVeiculoPossiveis);
        TipoVeiculo tipoVeiculo = gerenciadorDeTipoVeiculo.consultarPorDescricao(tipoVeiculoSelecionado);
        if (tipoVeiculo == null) {
            System.out.println(gerenciadorDeTipoVeiculo.getDescricaoDaEntidade() + " não encontrado. Tente novamente.");
            return;
        }
        Veiculo veiculoAlterado = gerenciadorDeVeiculo.adicionar(placa, modelo, tipoVeiculo);

        System.out.println(gerenciadorDeVeiculo.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(veiculoAlterado);
    }
}
