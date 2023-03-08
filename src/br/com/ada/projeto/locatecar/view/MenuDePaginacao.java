package br.com.ada.projeto.locatecar.view;

import br.com.ada.projeto.locatecar.business.paginacao.Pagina;
import br.com.ada.projeto.locatecar.business.paginacao.Paginavel;

import java.util.ArrayList;
import java.util.List;

public class MenuDePaginacao<T> {

    private static final String OPCAO_PAGINA_ANTERIOR = "A";
    private static final String OPCAO_PROXIMA_PAGINA = "P";
    private static final String OPCAO_VOLTAR = "V";
    private final Paginavel<T> paginacao;

    private final String descricaoDoTipo;

    public MenuDePaginacao(String descricaoDoTipo,  Paginavel<T> paginacao) {
        this.paginacao = paginacao;
        this.descricaoDoTipo = descricaoDoTipo;
    }

    public void paginar() {

        Pagina<T> primeiraPagina = paginacao.getPagina(0);
        if (primeiraPagina.elementosDaPagina().isEmpty()) {
            System.out.printf("Não existem %s cadastrados com esse filtro!%n", descricaoDoTipo);
            return;
        }

        iterarEntreAsPaginas(primeiraPagina);
    }

    private void iterarEntreAsPaginas(Pagina<T> primeiraPagina) {
        Pagina<T> paginaAtual = primeiraPagina;
        while (true) {
            exibirCabecalho(paginaAtual);
            exibirPagina(paginaAtual);
            exibirSeparador();

            int paginaSelecionada = selecionarProximaPagina(paginaAtual);

            if (paginaSelecionada == -1) {
                return;
            }

            paginaAtual = paginacao.getPagina(paginaSelecionada);
        }
    }

    private void exibirCabecalho(Pagina<T> paginaAtual) {
        exibirSeparador();
        System.out.printf("Página %s/%s%n", paginaAtual.indice() + 1, paginacao.getTotalPaginas());
        exibirSeparador();
    }

    private int selecionarProximaPagina(Pagina<T> paginaAtual) {
        if (naoEhAPrimeiraPagina(paginaAtual)) {
            System.out.println("<A> para ir para página anterior.");
        }
        if (!paginaAtual.ultimaPagina()) {
            System.out.println("<P> para ir para próxima página.");
        }
        System.out.println("<V> para voltar aos menus.");
        String opcao = capturarOpcao(paginaAtual);

        int paginaSelecionada = switch (opcao.toUpperCase()) {
            case "A" -> paginaAtual.indice() - 1;
            case "P" -> paginaAtual.indice() + 1;
            default -> -1;
        };
        return paginaSelecionada;
    }

    private String capturarOpcao(Pagina<T> paginaAtual) {

        List<String> opcoes = new ArrayList<>();
        opcoes.add(OPCAO_VOLTAR);
        if (naoEhAPrimeiraPagina(paginaAtual)) {
            opcoes.add(OPCAO_PAGINA_ANTERIOR);
        }

        if (!paginaAtual.ultimaPagina()) {
            opcoes.add(OPCAO_PROXIMA_PAGINA);
        }

        String opcao = CapturadorDeEntrada.capturarStringDentreAsPossiveis("a opção", opcoes);
        return opcao;

    }

    private boolean naoEhAPrimeiraPagina(Pagina<T> paginaAtual) {
        return paginaAtual.indice() != 0;
    }

    private void exibirPagina(Pagina<T> paginaAtual) {
        System.out.printf("%s encontrados na página %s: %n", descricaoDoTipo, paginaAtual.indice());
        paginaAtual.elementosDaPagina().forEach(System.out::println);
    }

    protected static void exibirSeparador() {
        System.out.println("--------------------------------------");
    }
}
