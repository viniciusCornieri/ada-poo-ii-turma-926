package br.com.ada.projeto.locatecar.business;

import br.com.ada.projeto.locatecar.business.exception.RegistroJaExistenteException;
import br.com.ada.projeto.locatecar.business.exception.RegistroNaoEncontradoException;
import br.com.ada.projeto.locatecar.business.paginacao.ListaPaginavel;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;
import br.com.ada.projeto.locatecar.model.ClientePessoaFisica;
import br.com.ada.projeto.locatecar.persistence.ClienteRepository;

import java.util.List;

public class GerenciadorDeClientePessoaFisica {

    private static final String DESCRICAO_ENTIDADE = "Cliente Pessoa Física";
    private static final String DESCRICAO_PLURAL_PLURAL = "Clientes Pessoa Física";
    private final ClienteRepository<ClientePessoaFisica> repository;

    public GerenciadorDeClientePessoaFisica(ClienteRepository<ClientePessoaFisica> repository) {
        this.repository = repository;
    }

    public ClientePessoaFisica adicionar(String cpf, String nome) {

        if (existe(cpf)) {
            throw new RegistroJaExistenteException(DESCRICAO_ENTIDADE, cpf);
        }

        ClientePessoaFisica novo = new ClientePessoaFisica(nome, cpf);
        ClientePessoaFisica salvo = repository.salvar(novo);
        return salvo;
    }

    public ClientePessoaFisica editar(String cpf, String nome) {

        ClientePessoaFisica cliente = consultarPorCpf(cpf);
        boolean clienteNaoExiste = cliente == null;

        if (clienteNaoExiste) {
            throw new RegistroNaoEncontradoException(DESCRICAO_ENTIDADE, cpf);
        }

        cliente.setNome(nome);
        repository.atualizar(cliente);
        return cliente;
    }

    public boolean deletar(String cpf) {
        return repository.deletar(cpf);
    }

    public ClientePessoaFisica consultarPorCpf(String cpf) {
        return repository.consultar(cpf);
    }

    public boolean existe(String cpf) {
        return repository.consultar(cpf) != null;
    }

    public List<ClientePessoaFisica> listarTodos() {
        return repository.listarTodos();
    }

    public Paginavel<ClientePessoaFisica> listarComPaginacao(int maximoDeElementosPorPagina) {
        return new ListaPaginavel<>(listarTodos(), maximoDeElementosPorPagina);
    }

    public String getDescricaoDaEntidade() {
        return DESCRICAO_ENTIDADE;
    }

    public String getDescricaoPluralDaEntidade() {
        return DESCRICAO_PLURAL_PLURAL;
    }

    public Paginavel<ClientePessoaFisica> listarComPaginacaoPorNome(int maximoDeElementosPorPagina, String nome) {
        return new ListaPaginavel<>(repository.buscarPorNome(nome), maximoDeElementosPorPagina);
    }
}
