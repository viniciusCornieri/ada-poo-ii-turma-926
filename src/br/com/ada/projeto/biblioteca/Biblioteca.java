package br.com.ada.projeto.biblioteca;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.biblioteca.business.GerenciadorDeLivro;
import br.com.ada.projeto.biblioteca.model.Autor;
import br.com.ada.projeto.biblioteca.model.Livro;
import br.com.ada.projeto.biblioteca.persistence.AutorRepository;
import br.com.ada.projeto.biblioteca.persistence.Repository;
import br.com.ada.projeto.biblioteca.persistence.memoria.AutorEmMemoriaRepository;
import br.com.ada.projeto.biblioteca.persistence.memoria.LivroEmMemoriaRepository;
import br.com.ada.projeto.biblioteca.view.MenuComSubmenus;
import br.com.ada.projeto.biblioteca.view.MenuGeralFactory;
import br.com.ada.projeto.biblioteca.view.autor.MenuDeAutoresFactory;
import br.com.ada.projeto.biblioteca.view.livro.MenuDeLivrosFactory;

public class Biblioteca {

    public static void main(String[] args) {
        Repository<Livro> repositorioDeLivro = new LivroEmMemoriaRepository();
        GerenciadorDeLivro gerenciadorDeLivro = new GerenciadorDeLivro(repositorioDeLivro);

        AutorRepository repositorioDeAutor = new AutorEmMemoriaRepository();
        GerenciadorDeAutor gerenciadorDeAutor = new GerenciadorDeAutor(repositorioDeAutor);

        Autor autor = gerenciadorDeAutor.adicionarAutor("J. R. R. Tolkien", "Inglaterra");
        gerenciadorDeAutor.adicionarAutor("Machado de Assis", "Brasil");
        gerenciadorDeAutor.adicionarAutor("J. K. Rowling", "Inglaterra");
        gerenciadorDeAutor.adicionarAutor("Shakespeare", "Inglaterra");
        gerenciadorDeAutor.adicionarAutor("Clarice Lispector", "Ucrania");
        gerenciadorDeAutor.adicionarAutor("Paulo Coelho", "Brasil");
        gerenciadorDeAutor.adicionarAutor("Saramago", "Portugal");

        gerenciadorDeLivro.adicionarLivro("O Hobbit", "123456", autor);

        gerenciadorDeLivro.listarTodos()
                .forEach(System.out::println);

        // Biblioteca nacional
        // 1. Menu Autores
        // 2. Menu Livros
        // 3. Menu de Empréstimos

        // Menu de Autores
        // 1. Adicionar autor
        // 2. Editar autor
        // 3. Remover autor
        // 4. Consultar autores por nacionalidade
        // 5. Listar todos

        MenuDeAutoresFactory menuDeAutoresFactory = new MenuDeAutoresFactory(gerenciadorDeAutor);
        MenuDeLivrosFactory menuDeLivrosFactory = new MenuDeLivrosFactory(gerenciadorDeAutor, gerenciadorDeLivro);

        MenuComSubmenus menuGeral = new MenuGeralFactory(menuDeAutoresFactory, menuDeLivrosFactory).create();
        menuGeral.agir();

    }
}
