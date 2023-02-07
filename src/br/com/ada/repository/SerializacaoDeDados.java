package br.com.ada.repository;

import br.com.ada.ordenacao.Livro;
import br.com.ada.ordenacao.Pessoa;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoDeDados {

    public static void main(String[] args) {
//        List<Pessoa> lista = new ArrayList<>();

        Pessoa vinicius = new Pessoa("Vini", LocalDate.of(1991, Month.DECEMBER, 15), "88291073015");
        Pessoa ana = new Pessoa("Ana", LocalDate.of(1991, Month.DECEMBER, 15), "41693734052");
//
//        ManipuladorDeArquivo.escreverEmArquivo(lista);
//        List<Pessoa> pessoas = ManipuladorDeArquivo.lerDoArquivo();
        Repository repositorioDePessoas = new PessoaEmArquivoRepository();
//        repositorioDePessoas.atualizar(vinicius);
//        repositorioDePessoas.salvar(ana);
        System.out.println(repositorioDePessoas.listarTodos());

        Livro livro = new Livro("O hobbit", "12345");
        Repository<Livro> livroRepository = new LivroEmArquivoRepository();
//        livroRepository.salvar(livro);
        System.out.println(livroRepository.listarTodos());
    }
}
