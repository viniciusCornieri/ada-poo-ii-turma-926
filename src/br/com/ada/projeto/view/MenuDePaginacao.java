package br.com.ada.projeto.view;

import br.com.ada.projeto.business.Pagina;
import br.com.ada.projeto.business.Paginavel;

import java.util.List;

public class MenuDePaginacao<T> {

    public static final String OPCAO_ANTERIOR = "A";
    public static final String OPCAO_PROXIMA = "P";
    public static final String OPCAO_VOLTAR = "V";
    public static final List<String> LISTA_DE_OPCOES = List.of(OPCAO_ANTERIOR, OPCAO_PROXIMA, OPCAO_VOLTAR);

    private final Paginavel<T> paginacao;

    private final String descricaoDoTipo;

    public MenuDePaginacao(String descricaoDoTipo,  Paginavel<T> paginacao) {
        this.paginacao = paginacao;
        this.descricaoDoTipo = descricaoDoTipo;
    }

    public void paginar() {

        Pagina<T> primeiraPagina = paginacao.getPagina(0);
        if (primeiraPagina.elementosDaPagina().isEmpty()) {
            System.out.println("Não existem %s cadastrados!".formatted(descricaoDoTipo));
            return;
        }

        Pagina<T> paginaAtual = primeiraPagina;
        while (true) {
            exibirSeparador();
            System.out.println("Página %s/%s".formatted(paginaAtual.indice() + 1, paginacao.getTotalPaginas()));
            exibirSeparador();
            exibirPagina(paginaAtual);
            exibirSeparador();

            int paginaSelecionada = selecionarProximaPagina(paginaAtual);

            if (paginaSelecionada == -1) {
                return;
            }

            paginaAtual = paginacao.getPagina(paginaSelecionada);
        }
    }

    private int selecionarProximaPagina(Pagina<T> paginaAtual) {
        if (!ehAPrimeiraPagina(paginaAtual)) {
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
        while (true) {
            String opcao = CapturadorDeEntrada.capturarString("a opção");
            validarSeEntradaValida(paginaAtual, opcao);
            boolean opcaoValida = validarSeEntradaValida(paginaAtual, opcao);
            if (opcaoValida) {
                return opcao;
            }
            System.out.println("Opcao %s é inválida somente %s são aceitas.".formatted(opcao, LISTA_DE_OPCOES));
        }
    }

    private boolean ehAPrimeiraPagina(Pagina<T> paginaAtual) {
        return paginaAtual.indice() == 0;
    }

    private boolean validarSeEntradaValida(Pagina<T> paginaAtual, String opcao) {
        if (ehAPrimeiraPagina(paginaAtual) && "A".equalsIgnoreCase(opcao)) {
            return false;
        }

        if (paginaAtual.ultimaPagina() && "P".equalsIgnoreCase(opcao)) {
            return false;
        }

        return LISTA_DE_OPCOES.contains(opcao.toUpperCase());
    }

    private void exibirPagina(Pagina<T> paginaAtual) {
        System.out.println(descricaoDoTipo + " encontrados na página %s: ".formatted(paginaAtual.indice()));
        paginaAtual.elementosDaPagina().forEach(System.out::println);
    }

    protected static void exibirSeparador() {
        System.out.println("--------------------------------------");
    }
}
