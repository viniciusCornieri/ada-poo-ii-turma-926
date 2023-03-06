package br.com.ada.projeto.locatecar.business.exception;

public class PaginaForaDosLimites extends RuntimeException {

    public static final String TEMPLATE_MENSAGEM = "Pagina com indice %s está fora dos limites aceitos, numero total de Pagina %s";

    public PaginaForaDosLimites(int indiceDaPagina, int numeroTotalDePaginas) {
        super(TEMPLATE_MENSAGEM.formatted(indiceDaPagina, numeroTotalDePaginas));
    }
}
