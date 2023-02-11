package br.com.ada.projeto;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.business.GerenciadorDeLivro;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.model.Livro;
import br.com.ada.projeto.persistence.AutorRepository;
import br.com.ada.projeto.persistence.Repository;
import br.com.ada.projeto.persistence.memoria.AutorEmMemoriaRepository;
import br.com.ada.projeto.persistence.memoria.LivroEmMemoriaRepository;
import br.com.ada.projeto.view.MenuComSubmenus;
import br.com.ada.projeto.view.MenuGeralFactory;
import br.com.ada.projeto.view.autor.MenuDeAutoresFactory;
import br.com.ada.projeto.view.livro.MenuDeLivrosFactory;

public class Biblioteca {

    public static void main(String[] args) {
        Repository<Livro> repositorioDeLivro = new LivroEmMemoriaRepository();
        GerenciadorDeLivro gerenciadorDeLivro = new GerenciadorDeLivro(repositorioDeLivro);

        AutorRepository repositorioDeAutor = new AutorEmMemoriaRepository();
        GerenciadorDeAutor gerenciadorDeAutor = new GerenciadorDeAutor(repositorioDeAutor);

        Autor autor = gerenciadorDeAutor.adicionarAutor("J. R. R. Tolkien", "Inglaterra");
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
