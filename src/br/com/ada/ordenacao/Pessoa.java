package br.com.ada.ordenacao;

import br.com.ada.repository.Entidade;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Pessoa implements Comparable, Serializable, Entidade {

    public static final Comparator<Pessoa> COMPARADOR_POR_NOME = Comparator.comparing(Pessoa::getNome);
    public static final Comparator<Pessoa> COMPARADOR_POR_NOME_LAMBDA = Comparator.comparing((pessoa) -> pessoa.getNome());
    public static final Comparator<Pessoa> COMPARADOR_POR_IDADE_E_NOME = Comparator
            .comparing(Pessoa::getDataDeNascimento).reversed()
            .thenComparing(Pessoa::getNome);

    public static final Comparator<Pessoa> COMPARADOR_POR_IDADE = Comparator
            .comparing(Pessoa::getIdade);
    private final String nome;

    private final LocalDate dataDeNascimento;

    private String Sobrenome;

    private String cpf;

    /*
     * {
     *  "nome": "Vinicius",
     *  "sobrenome: "Cornieri",
     *  "dataDeNascimento": "1991-12-15",
     *  "cpf": "000000000"
     * }
     *
     *
     */

    public Pessoa(String nome, LocalDate dataDeNascimento, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    @Override
    public int compareTo(Object objetoAComparar) {
        if (!(objetoAComparar instanceof Pessoa)) {
            throw new IllegalArgumentException("Somente é possivel comparar pessoas com outra pessoa");
        }

        Pessoa pessoaAComparar = (Pessoa) objetoAComparar;
//        int comparacaoDeIdadeDoMaisNovoParaOMaisVelho = this.dataDeNascimento.compareTo(pessoaAComparar.dataDeNascimento) * -1;
//
//        boolean possuemAMesmaIdade = comparacaoDeIdadeDoMaisNovoParaOMaisVelho == 0;
//        if (possuemAMesmaIdade) {
//            return this.getNome().compareTo(pessoaAComparar.getNome());
//        }
//
//        return comparacaoDeIdadeDoMaisNovoParaOMaisVelho;

        return COMPARADOR_POR_IDADE_E_NOME.compare(this, pessoaAComparar);
    }
    // Ordenar a lista de pessoas por nome em ordem alfabética.

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + "'," +
                "dataDeNascimento='" + dataDeNascimento + '\'' +
                "idade='" + getIdade() + '\'' +
                '}';
    }
}
