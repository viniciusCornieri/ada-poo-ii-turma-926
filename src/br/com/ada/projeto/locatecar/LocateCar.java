package br.com.ada.projeto.locatecar;

import br.com.ada.projeto.locatecar.business.GerenciadorDeTipoVeiculo;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.persistence.TipoVeiculoRepository;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;
import br.com.ada.projeto.locatecar.persistence.arquivo.ManipuladorDeArquivoComObjectIOStream;
import br.com.ada.projeto.locatecar.persistence.arquivo.TipoDeVeiculoRepositoryEmArquivo;
import br.com.ada.projeto.locatecar.persistence.arquivo.VeiculoRepositoryEmArquivo;
import br.com.ada.projeto.locatecar.persistence.memoria.TipoDeVeiculoRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.persistence.memoria.VeiculoRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.view.Menu;
import br.com.ada.projeto.locatecar.view.MenuGeralFactory;
import br.com.ada.projeto.locatecar.view.veiculo.MenuDeVeiculosFactory;

import java.math.BigDecimal;

public class LocateCar {

    public static void main(String[] args) {
        VeiculoRepository veiculoRepository = new VeiculoRepositoryEmArquivo(new ManipuladorDeArquivoComObjectIOStream("veiculos.txt"), new VeiculoRepositoryEmMemoria());
        TipoVeiculoRepository tipoVeiculoRepository = new TipoDeVeiculoRepositoryEmArquivo(new ManipuladorDeArquivoComObjectIOStream("tipos_de_veiculo.txt"), new TipoDeVeiculoRepositoryEmMemoria());

        GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo = new GerenciadorDeTipoVeiculo(tipoVeiculoRepository);
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo(veiculoRepository);
        MenuDeVeiculosFactory menuDeVeiculosFactory = new MenuDeVeiculosFactory(gerenciadorDeVeiculo, gerenciadorDeTipoVeiculo);
        Menu menuGeral = new MenuGeralFactory(menuDeVeiculosFactory).create();
        menuGeral.agir();

    }

    private static void popularTipoDeVeiculos(GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo) {
        gerenciadorDeTipoVeiculo.adicionar("pequeno", BigDecimal.valueOf(100));
        gerenciadorDeTipoVeiculo.adicionar("medio", BigDecimal.valueOf(150));
        gerenciadorDeTipoVeiculo.adicionar("SUV", BigDecimal.valueOf(200));
    }

}
