package br.com.ada.projeto.view.autor;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.business.Pagina;
import br.com.ada.projeto.business.Paginavel;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.view.CapturadorDeEntrada;
import br.com.ada.projeto.view.ConstanteDePaginacao;
import br.com.ada.projeto.view.MenuDePaginacao;
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
        MenuDePaginacao<Autor> menuDePaginacao = new MenuDePaginacao<>("Autores", gerenciadorDeAutor.listarComPaginacao(ConstanteDePaginacao.MAXIMO_DE_ELEMENTOS_POR_PAGINA));
        menuDePaginacao.paginar();
    }
}
