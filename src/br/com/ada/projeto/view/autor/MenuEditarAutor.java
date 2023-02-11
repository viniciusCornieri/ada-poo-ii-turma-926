package br.com.ada.projeto.view.autor;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.view.CapturadorDeEntrada;
import br.com.ada.projeto.view.Submenu;

public class MenuEditarAutor extends Submenu {

    private final GerenciadorDeAutor gerenciadorDeAutor;

    public MenuEditarAutor(GerenciadorDeAutor gerenciadorDeAutor) {
        super("Editar " + GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE);
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("o nome");

        if (!gerenciadorDeAutor.existeAutor(nome)) {
            System.out.println("Não existe um autor com esse nome");
            return;
        }

        String nacionalidade = CapturadorDeEntrada.capturarString("a nacionalidade");
        Autor altorAlterado = gerenciadorDeAutor.editarAutor(nome, nacionalidade);

        System.out.println(GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE + " alterado com sucesso");
        System.out.println(altorAlterado);
    }
}
