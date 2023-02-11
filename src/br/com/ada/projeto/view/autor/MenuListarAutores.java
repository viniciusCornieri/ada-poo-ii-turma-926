package br.com.ada.projeto.view.autor;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.view.Submenu;

import java.util.List;

public class MenuListarAutores extends Submenu {

    private final GerenciadorDeAutor gerenciadorDeAutor;


    public MenuListarAutores(GerenciadorDeAutor gerenciadorDeAutor) {
        super("Listar todos " + GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE);
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        List<Autor> autores = gerenciadorDeAutor.listarTodos();

        if (autores.isEmpty()) {
            System.out.println("Não existem autores cadastrados!");
            return;
        }

        System.out.println("Autores encontrados: ");
        autores.forEach(System.out::println);

    }
}
