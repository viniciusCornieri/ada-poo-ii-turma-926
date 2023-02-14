package br.com.ada.projeto.business;

public interface Paginavel<T> {

    Pagina<T> getPagina(int indicePagina);
    int getTotalElementos();
    int getTotalPaginas();
    int getMaximoDeElementosPorPagina();
}
