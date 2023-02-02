package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.util.List;

public class PessoaEmArquivoRepository implements Repository {

    private PessoaEmMemoriaRepository pessoaEmMemoriaRepository;

    public PessoaEmArquivoRepository() {
        List<Pessoa> dadosIniciais = ManipuladorDeArquivo.lerDoArquivo();
        System.out.println("Dados iniciais: " + dadosIniciais);
        this.pessoaEmMemoriaRepository = new PessoaEmMemoriaRepository(dadosIniciais);
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaEmMemoriaRepository.salvar(pessoa);
        persistir();
        return pessoaSalva;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoaEmMemoriaRepository.atualizar(pessoa);
        persistir();
    }

    @Override
    public boolean deletar(String cpf) {
        boolean pessoaFoiDeletada = pessoaEmMemoriaRepository.deletar(cpf);
        if (pessoaFoiDeletada) {
            persistir();
        }
        return pessoaFoiDeletada;
    }

    @Override
    public Pessoa consultar(String cpf) {
        return pessoaEmMemoriaRepository.consultar(cpf);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return pessoaEmMemoriaRepository.listarTodos();
    }

    private void persistir() {
        ManipuladorDeArquivo.escreverEmArquivo(listarTodos());
    }
}
