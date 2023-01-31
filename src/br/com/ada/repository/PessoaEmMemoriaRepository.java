package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PessoaEmMemoriaRepository implements Repository {

    private List<Pessoa> dados = new ArrayList<>();
    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if (existe(pessoa)) {
            throw new IllegalArgumentException("Já existe uma pessoa com esse CPF cadastrado");
        }
        dados.add(pessoa);
        return pessoa;
    }

    private boolean existe(Pessoa pessoa) {
        String cpf = pessoa.getCpf();
        return existe(cpf);
    }

    private boolean existe(String cpf) {
        return consultar(cpf) != null;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        if (!existe(pessoa)) {
            throw new IllegalArgumentException("Não existe uma pessoa com esse CPF cadastrado para atualizar");
        }

        deletar(pessoa.getCpf());
        salvar(pessoa);
    }

    @Override
    public boolean deletar(String cpf) {
        if (existe(cpf)) {
            Pessoa consultar = consultar(cpf);
            dados.remove(consultar);
            return true;
        }
        return false;
    }

    @Override
    public Pessoa consultar(String cpf) {
        for (Pessoa pessoa: dados) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;

//        Optional<Pessoa> pessoa = dados.stream()
//                .filter(p -> p.getCpf().equals(cpf))
//                .findFirst();
//        return pessoa.orElse(null);
    }

    @Override
    public List<Pessoa> listarTodos() {
        return new ArrayList<>(dados);
    }
}
