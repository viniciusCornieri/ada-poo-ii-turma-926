package br.com.ada.projeto.locatecar.business;

import br.com.ada.projeto.locatecar.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.locatecar.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.locatecar.business.paginacao.ListaPaginavel;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.TipoVeiculo;
import br.com.ada.projeto.locatecar.model.Veiculo;
import br.com.ada.projeto.locatecar.persistence.VeiculoRepository;

import java.util.List;

public class GerenciadorDeVeiculo {

    private static final String DESCRICAO_ENTIDADE = "Veiculo";
    private static final String DESCRICAO_PLURAL_PLURAL = "Veiculos";
    private final VeiculoRepository repository;

    public GerenciadorDeVeiculo(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo adicionar(String placa, String modelo, TipoVeiculo tipoVeiculo) {

        if (existe(placa)) {
            throw new RegistroJaExistenteException(DESCRICAO_ENTIDADE, placa);
        }

        Veiculo novo = new Veiculo(placa, modelo, tipoVeiculo);
        Veiculo salvo = repository.salvar(novo);
        return salvo;
    }

    public Veiculo editar(String placa, String modelo, TipoVeiculo tipoVeiculo) {

        Veiculo veiculo = consultarPorPlaca(placa);
        boolean veiculoNaoExiste = veiculo == null;

        if (veiculoNaoExiste) {
            throw new RegistroNaoEncontradoException(DESCRICAO_ENTIDADE, placa);
        }

        if (tipoVeiculo == null) {
            throw new IllegalArgumentException("Tipo Veiculo não pode ser nulo");
        }

        veiculo.setModelo(modelo);
        veiculo.setTipo(tipoVeiculo);
        repository.atualizar(veiculo);
        return veiculo;
    }

    public boolean deletar(String placa) {
        return repository.deletar(placa);
    }

    public Veiculo consultarPorPlaca(String placa) {
        return repository.consultar(placa);
    }

    public boolean existe(String placa) {
        return repository.consultar(placa) != null;
    }

    public List<Veiculo> listarTodos() {
        return repository.listarTodos();
    }

    public Paginavel<Veiculo> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

    public String getDescricaoDaEntidade() {
        return DESCRICAO_ENTIDADE;
    }

    public String getDescricaoPluralDaEntidade() {
        return DESCRICAO_PLURAL_PLURAL;
    }
}
