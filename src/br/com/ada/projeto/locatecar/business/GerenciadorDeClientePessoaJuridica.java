package br.com.ada.projeto.locatecar.business;

import br.com.ada.projeto.locatecar.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.locatecar.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.locatecar.business.paginacao.ListaPaginavel;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.model.ClientePessoaJuridica;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;

import java.util.List;

public class GerenciadorDeClientePessoaJuridica {

    private static final String DESCRICAO_ENTIDADE = "Cliente Pessoa Jurídica";
    private static final String DESCRICAO_PLURAL_PLURAL = "Clientes Pessoa Jurídica";
    private final ClienteRepository<ClientePessoaJuridica> repository;

    public GerenciadorDeClientePessoaJuridica(ClienteRepository<ClientePessoaJuridica> repository) {
        this.repository = repository;
    }

    public ClientePessoaJuridica adicionar(String cnpj, String nome) {

        if (existe(cnpj)) {
            throw new RegistroJaExistenteException(DESCRICAO_ENTIDADE, cnpj);
        }

        ClientePessoaJuridica novo = new ClientePessoaJuridica(nome, cnpj);
        ClientePessoaJuridica salvo = repository.salvar(novo);
        return salvo;
    }

    public ClientePessoaJuridica editar(String cnpj, String nome) {

        ClientePessoaJuridica cliente = consultarPorCpf(cnpj);
        boolean clienteNaoExiste = cliente == null;

        if (clienteNaoExiste) {
            throw new RegistroNaoEncontradoException(DESCRICAO_ENTIDADE, cnpj);
        }

        cliente.setNome(nome);
        repository.atualizar(cliente);
        return cliente;
    }

    public boolean deletar(String cnpj) {
        return repository.deletar(cnpj);
    }

    public ClientePessoaJuridica consultarPorCpf(String cnpj) {
        return repository.consultar(cnpj);
    }

    public boolean existe(String cnpj) {
        return repository.consultar(cnpj) != null;
    }

    public List<ClientePessoaJuridica> listarTodos() {
        return repository.listarTodos();
    }

    public Paginavel<ClientePessoaJuridica> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

    public String getDescricaoDaEntidade() {
        return DESCRICAO_ENTIDADE;
    }

    public String getDescricaoPluralDaEntidade() {
        return DESCRICAO_PLURAL_PLURAL;
    }

    public Paginavel<ClientePessoaJuridica> listarComPaginacaoPorNome(int maximoDeElementosPorPagina, String nome) {
        return new ListaPaginavel<>(repository.buscarPorNome(nome), maximoDeElementosPorPagina);
    }
}
