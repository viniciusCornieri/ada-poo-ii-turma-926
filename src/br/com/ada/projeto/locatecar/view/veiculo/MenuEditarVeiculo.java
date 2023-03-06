package br.com.ada.projeto.locatecar.view.veiculo;

import br.com.ada.projeto.locatecar.business.GerenciadorDeTipoVeiculo;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

import java.util.List;

import static br.com.ada.projeto.locatecar.view.CapturadorDeEntrada.capturarStringDentreAsPossiveis;


public class MenuEditarVeiculo extends Submenu {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;
    private final GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo;

    public MenuEditarVeiculo(GerenciadorDeVeiculo gerenciadorDeVeiculo, GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo) {
        super("Editar " + gerenciadorDeVeiculo.getDescricaoDaEntidade());
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.gerenciadorDeTipoVeiculo = gerenciadorDeTipoVeiculo;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a placa do veiculo");

        Veiculo veiculo = gerenciadorDeVeiculo.consultarPorPlaca(placa);
        boolean naoExisteVeiculo = veiculo == null;
        if (naoExisteVeiculo) {
            System.out.printf("Não existe um %s com essa placa.%n", gerenciadorDeVeiculo.getDescricaoDaEntidade());
            return;
        }

        String modelo = CapturadorDeEntrada.capturarString("o modelo. Valor anterior[%s]".formatted(veiculo.getModelo()));

        List<String> tiposDeVeiculoPossiveis = gerenciadorDeTipoVeiculo.listarTodos().stream().map(TipoVeiculo::getId).toList();

        String mensagemDoCampoTipoVeiculo = "o %s. Valor anterior[%s]".formatted(gerenciadorDeTipoVeiculo.getDescricaoDaEntidade(), veiculo.getTipo().getId());
        String tipoVeiculoSelecionado = capturarStringDentreAsPossiveis(mensagemDoCampoTipoVeiculo, tiposDeVeiculoPossiveis);
        TipoVeiculo tipoVeiculo = gerenciadorDeTipoVeiculo.consultarPorDescricao(tipoVeiculoSelecionado);
        if (tipoVeiculo == null) {
            System.out.println(gerenciadorDeTipoVeiculo.getDescricaoDaEntidade() + " não encontrado. Tente novamente.");
            return;
        }
        Veiculo veiculoAlterado = gerenciadorDeVeiculo.editar(placa, modelo, tipoVeiculo);

        System.out.println(gerenciadorDeVeiculo.getDescricaoDaEntidade() + " alterado com sucesso");
        System.out.println(veiculoAlterado);
    }
}
