package br.com.ada.projeto.locatecar.business;

import br.com.ada.projeto.locatecar.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.locatecar.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.locatecar.business.paginacao.ListaPaginavel;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.persistence.TipoVeiculoRepository;

import java.math.BigDecimal;
import java.util.List;

public class GerenciadorDeTipoVeiculo {

    private static final String DESCRICAO_ENTIDADE = "Tipo de Veiculo";
    private static final String DESCRICAO_PLURAL_PLURAL = "Tipos de Veiculo";
    private final TipoVeiculoRepository repository;

    public GerenciadorDeTipoVeiculo(TipoVeiculoRepository repository) {
        this.repository = repository;
    }

    public TipoVeiculo adicionar(String descricao, BigDecimal tarifa) {

        if (existe(descricao)) {
            throw new RegistroJaExistenteException(DESCRICAO_ENTIDADE, descricao);
        }

        if (tarifaEhNegativa(tarifa)) {
            throw new IllegalArgumentException("Campo tarifa de " + DESCRICAO_ENTIDADE + " não pode ser negativa");
        }

        TipoVeiculo novo = new TipoVeiculo(descricao, tarifa);
        TipoVeiculo salvo = repository.salvar(novo);
        return salvo;
    }

    private static boolean tarifaEhNegativa(BigDecimal tarifa) {
        return tarifa.compareTo(BigDecimal.ZERO) <= 0;
    }

    public TipoVeiculo editar(String descricao, BigDecimal tarifa) {
        descricao = descricao.toUpperCase();
        TipoVeiculo tipoVeiculo = consultarPorDescricao(descricao);
        boolean veiculoNaoExiste = tipoVeiculo == null;

        if (veiculoNaoExiste) {
            throw new RegistroNaoEncontradoException(DESCRICAO_ENTIDADE, descricao);
        }

        if (tarifaEhNegativa(tarifa)) {
            throw new IllegalArgumentException("Campo tarifa de " + DESCRICAO_ENTIDADE + " não pode ser negativa");
        }

        tipoVeiculo.setTarifa(tarifa);
        repository.atualizar(tipoVeiculo);
        return tipoVeiculo;
    }

    public boolean deletar(String nome) {
        return repository.deletar(nome);
    }

    public TipoVeiculo consultarPorDescricao(String descricao) {
        return repository.consultar(descricao.toUpperCase());
    }

    public boolean existe(String descricao) {
        return repository.consultar(descricao) != null;
    }

    public List<TipoVeiculo> listarTodos() {
        return repository.listarTodos();
    }

    public Paginavel<TipoVeiculo> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

    public String getDescricaoDaEntidade() {
        return DESCRICAO_ENTIDADE;
    }

    public String getDescricaoPluralDaEntidade() {
        return DESCRICAO_PLURAL_PLURAL;
    }
}
