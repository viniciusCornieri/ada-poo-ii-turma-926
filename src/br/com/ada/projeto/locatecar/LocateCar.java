package br.com.ada.projeto.locatecar;

import br.com.ada.projeto.locatecar.business.*;
import br.com.ada.projeto.locatecar.business.desconto.FactoryDeCorrenteDeDesconto;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.persistence.AluguelRepository;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;
import br.com.ada.projeto.locatecar.persistence.TipoVeiculoRepository;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;
import br.com.ada.projeto.locatecar.persistence.arquivo.*;
import br.com.ada.projeto.locatecar.persistence.memoria.AluguelRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.persistence.memoria.ClienteRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.persistence.memoria.TipoDeVeiculoRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.persistence.memoria.VeiculoRepositoryEmMemoria;
import br.com.ada.projeto.locatecar.view.Menu;
import br.com.ada.projeto.locatecar.view.MenuGeralFactory;
import br.com.ada.projeto.locatecar.view.aluguel.MenuDeAlugueisFactory;
import br.com.ada.projeto.locatecar.view.cliente.pessoafisica.MenuDeClientesPessoaFisicaFactory;
import br.com.ada.projeto.locatecar.view.cliente.pessoajuridica.MenuDeClientesPessoaJuridicaFactory;
import br.com.ada.projeto.locatecar.view.veiculo.MenuDeVeiculosFactory;

import java.math.BigDecimal;

public class LocateCar {

    public static void main(String[] args) {
        TipoVeiculoRepository tipoVeiculoRepository = new TipoDeVeiculoRepositoryEmArquivo(new ManipuladorDeArquivoComObjectIOStream("tipos_de_veiculo.txt"), new TipoDeVeiculoRepositoryEmMemoria());
        GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo = new GerenciadorDeTipoVeiculo(tipoVeiculoRepository);
        popularTipoDeVeiculos(gerenciadorDeTipoVeiculo);

        VeiculoRepository veiculoRepository = new VeiculoRepositoryEmArquivo(new ManipuladorDeArquivoComObjectIOStream("veiculos.txt"), new VeiculoRepositoryEmMemoria());
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo(veiculoRepository);
        MenuDeVeiculosFactory menuDeVeiculosFactory = new MenuDeVeiculosFactory(gerenciadorDeVeiculo, gerenciadorDeTipoVeiculo);

        ClienteRepository<ClientePessoaFisica> pessoaFisicaRepository = new ClienteRepositoryEmArquivo<>(new ManipuladorDeArquivoComObjectIOStream("clientes_pessoa_fisica.txt"), new ClienteRepositoryEmMemoria<>());
        GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica = new GerenciadorDeClientePessoaFisica(pessoaFisicaRepository);
        MenuDeClientesPessoaFisicaFactory menuDeClientesPessoaFisicaFactory = new MenuDeClientesPessoaFisicaFactory(gerenciadorDeClientePessoaFisica);

        ClienteRepository<ClientePessoaJuridica> pessoaJuridicaRepository = new ClienteRepositoryEmArquivo<>(new ManipuladorDeArquivoComObjectIOStream("clientes_pessoa_juridica.txt"), new ClienteRepositoryEmMemoria<>());
        GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica = new GerenciadorDeClientePessoaJuridica(pessoaJuridicaRepository);
        MenuDeClientesPessoaJuridicaFactory menuDeClientesPessoaJuridicaFactory = new MenuDeClientesPessoaJuridicaFactory(gerenciadorDeClientePessoaJuridica);

        AluguelRepository aluguelRepository = new AluguelRepositoryEmArquivo(new ManipuladorDeArquivoComObjectIOStream("alugueis.txt"), new AluguelRepositoryEmMemoria());
        GerenciadorDeAluguel gerenciadorDeAluguel = new GerenciadorDeAluguel(aluguelRepository, gerenciadorDeVeiculo, FactoryDeCorrenteDeDesconto.criarCorrenteDeDesconto());
        MenuDeAlugueisFactory menuDeAlugueisFactory = new MenuDeAlugueisFactory(gerenciadorDeVeiculo, gerenciadorDeClientePessoaFisica, gerenciadorDeClientePessoaJuridica, gerenciadorDeAluguel);

        Menu menuGeral = new MenuGeralFactory(menuDeVeiculosFactory, menuDeClientesPessoaFisicaFactory, menuDeClientesPessoaJuridicaFactory, menuDeAlugueisFactory).create();
        menuGeral.agir();

    }

    private static void popularTipoDeVeiculos(GerenciadorDeTipoVeiculo gerenciadorDeTipoVeiculo) {
        if (gerenciadorDeTipoVeiculo.listarTodos().isEmpty()) {
            gerenciadorDeTipoVeiculo.adicionar("PEQUENO", BigDecimal.valueOf(100));
            gerenciadorDeTipoVeiculo.adicionar("MEDIO", BigDecimal.valueOf(150));
            gerenciadorDeTipoVeiculo.adicionar("SUV", BigDecimal.valueOf(200));
        }
    }

}
