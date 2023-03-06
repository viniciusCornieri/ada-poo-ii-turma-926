package br.com.ada.projeto.locatecar.view.veiculo;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuDeletarVeiculo extends Submenu {

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    public MenuDeletarVeiculo(GerenciadorDeVeiculo gerenciadorDeVeiculo) {
        super("Deletar " + gerenciadorDeVeiculo.getDescricaoDaEntidade());
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    @Override
    public void acao() {
        String placa = CapturadorDeEntrada.capturarString("a placa");

        boolean foiDeletado = gerenciadorDeVeiculo.deletar(placa);

        if (foiDeletado) {
            System.out.println(gerenciadorDeVeiculo.getDescricaoDaEntidade() + " deletado com sucesso!");
        } else {
            System.out.printf("Não foi encontrado um %s com esse nome para deletar.", gerenciadorDeVeiculo.getDescricaoDaEntidade());
        }
    }
}
