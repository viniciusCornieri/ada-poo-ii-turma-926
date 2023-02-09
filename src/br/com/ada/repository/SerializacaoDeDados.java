package br.com.ada.repository;

import br.com.ada.ordenacao.Pessoa;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.Repository;
import br.com.ada.projeto.persistence.arquivo.LivroEmArquivoRepository;
import br.com.ada.projeto.persistence.arquivo.ManipuladorDeArquivo;
import br.com.ada.projeto.persistence.arquivo.ManipuladorDeArquivoComObjectIOStream;
import br.com.ada.projeto.persistence.memoria.LivroEmMemoriaRepository;

import java.time.LocalDate;
import java.time.Month;

public class SerializacaoDeDados {

    public static void main(String[] args) {
//        List<Pessoa> lista = new ArrayList<>();

        Pessoa vinicius = new Pessoa("Vini", LocalDate.of(1991, Month.DECEMBER, 15), "88291073015");
        Pessoa ana = new Pessoa("Ana", LocalDate.of(1991, Month.DECEMBER, 15), "41693734052");
//
//        ManipuladorDeArquivo.escreverEmArquivo(lista);
//        List<Pessoa> pessoas = ManipuladorDeArquivo.lerDoArquivo();
        ManipuladorDeArquivo manipuladorDeArquivoDePessoas = new ManipuladorDeArquivoComObjectIOStream("dados_pessoa.txt");
        Repository<Pessoa> repositorioDePessoas = new PessoaEmArquivoRepository(manipuladorDeArquivoDePessoas, new PessoaEmMemoriaRepository());
//        repositorioDePessoas.salvar(vinicius);
//        repositorioDePessoas.salvar(ana);
        System.out.println(repositorioDePessoas.listarTodos());

        Livro livro = new Livro("O hobbit", "12345");
        ManipuladorDeArquivo manipuladorDeArquivoDeLivros = new ManipuladorDeArquivoComObjectIOStream("livros.txt");
        Repository<Livro> livroRepository = new LivroEmArquivoRepository(manipuladorDeArquivoDeLivros, new LivroEmMemoriaRepository());
//        livroRepository.salvar(livro);
        System.out.println(livroRepository.listarTodos());
    }
}
