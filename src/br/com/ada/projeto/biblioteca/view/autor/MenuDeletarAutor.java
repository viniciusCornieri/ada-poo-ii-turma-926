package br.com.ada.projeto.biblioteca.view.autor;

import br.com.ada.projeto.biblioteca.business.GerenciadorDeAutor;
import br.com.ada.projeto.biblioteca.view.CapturadorDeEntrada;
import br.com.ada.projeto.biblioteca.view.Submenu;

public class MenuDeletarAutor extends Submenu {

    private final GerenciadorDeAutor gerenciadorDeAutor;

    public MenuDeletarAutor(GerenciadorDeAutor gerenciadorDeAutor) {
        super("Deletar " + GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE);
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("o nome");

        Boolean autorFoiDeletado = gerenciadorDeAutor.deletarAutor(nome);

        if (autorFoiDeletado) {
            System.out.println("Autor deletado com sucesso!");
        } else {
            System.out.println("Não foi encontrado um autor com esse nome para deletar.");
        }
    }
}
