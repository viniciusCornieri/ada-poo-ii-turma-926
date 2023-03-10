package br.com.ada.projeto.locatecar.business;

import br.com.ada.projeto.locatecar.business.desconto.CalculadorDeDesconto;
import br.com.ada.projeto.locatecar.business.exception.AluguelJaEncerradoException;
import br.com.ada.projeto.locatecar.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.locatecar.business.paginacao.ListaPaginavel;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.Cliente;
import br.com.ada.projeto.locatecar.model.StatusAluguel;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.persistence.AluguelRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class GerenciadorDeAluguel {

    private static final String DESCRICAO_ENTIDADE = "ALuguel";
    private static final String DESCRICAO_PLURAL_PLURAL = "Aluguéis";
    private final AluguelRepository repository;

    private final GerenciadorDeVeiculo gerenciadorDeVeiculo;

    private final CalculadorDeDesconto calculadorDeDesconto;

    public GerenciadorDeAluguel(AluguelRepository repository, GerenciadorDeVeiculo gerenciadorDeVeiculo, CalculadorDeDesconto calculadorDeDesconto) {
        this.repository = repository;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
        this.calculadorDeDesconto = calculadorDeDesconto;
    }

    public Aluguel alugar(Cliente cliente, Veiculo veiculo) {

        gerenciadorDeVeiculo.alugar(veiculo);

        Aluguel aluguel = new Aluguel(cliente, veiculo, LocalDateTime.now());
        Aluguel salvo = repository.salvar(aluguel);
        return salvo;
    }

    public Aluguel devolver(UUID idDoAluguel) {

        Aluguel aluguel = consultarPorId(idDoAluguel);

        if (aluguel == null) {
            throw new RegistroNaoEncontradoException(getDescricaoDaEntidade(), idDoAluguel.toString());
        }

        if (StatusAluguel.ENCERRADO == aluguel.getStatus()) {
            throw new AluguelJaEncerradoException(aluguel);
        }
        gerenciadorDeVeiculo.devolver(aluguel.getVeiculo());
        aluguel.setDataDevolucao(LocalDateTime.now());
        aluguel.setStatus(StatusAluguel.ENCERRADO);

        BigDecimal desconto = calculadorDeDesconto.calculaDesconto(aluguel);
        aluguel.setDesconto(desconto);

        repository.atualizar(aluguel);
        return aluguel;
    }

    public List<Aluguel> listarTodos() {
        return repository.listarTodos();
    }

    public Paginavel<Aluguel> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

    public Paginavel<Aluguel> listarEmAndamentoComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarAlugueisEmAndamento(), maximoDeElementosPorPagina);
    }

    private List<Aluguel> listarAlugueisEmAndamento() {
        return repository.listarAlugueisEmAndamento();
    }

    public Aluguel consultarPorId(UUID id) {
        return repository.consultar(id);
    }

    public boolean existe(UUID id) {
        return consultarPorId(id) != null;
    }

    public String getDescricaoDaEntidade() {
        return DESCRICAO_ENTIDADE;
    }

    public String getDescricaoPluralDaEntidade() {
        return DESCRICAO_PLURAL_PLURAL;
    }
}
