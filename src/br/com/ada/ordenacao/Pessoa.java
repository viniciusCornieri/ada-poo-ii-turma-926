package br.com.ada.ordenacao;

import java.time.LocalDate;

public class Pessoa implements Comparable {

    private final String nome;

    private final LocalDate dataDeNascimento;

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public int compareTo(Object objetoAComparar) {
        if (!(objetoAComparar instanceof Pessoa)) {
            throw new IllegalArgumentException("Somente é possivel comparar pessoas com outra pessoa");
        }
        Pessoa pessoaAComparar = (Pessoa) objetoAComparar;
        return this.nome.compareTo(pessoaAComparar.nome);
    }
    // Ordenar a lista de pessoas por nome em ordem alfabética.


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
