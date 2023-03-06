package br.com.ada.projeto.locatecar.business.paginacao;

public interface Paginavel<T> {

    Pagina<T> getPagina(int indicePagina);
    int getTotalElementos();
    int getTotalPaginas();
    int getMaximoDeElementosPorPagina();
}
