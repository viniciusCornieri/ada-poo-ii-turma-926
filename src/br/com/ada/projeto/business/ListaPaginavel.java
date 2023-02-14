package br.com.ada.projeto.business;

import br.com.ada.projeto.business.exception.PaginaForaDosLimites;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ListaPaginavel<T> implements Paginavel<T> {

    private final List<T> elementos;

    private final int maximoDeElementosPorPagina;

    public ListaPaginavel(List<T> elementos, int maximoDeElementosPorPagina) {
        this.elementos = elementos;
        this.maximoDeElementosPorPagina = maximoDeElementosPorPagina;
    }

    @Override
    public Pagina<T> getPagina(int indicePagina) {

        if (indicePagina < 0 || indicePagina > indiceMaximoDasPaginas()) {
            throw new PaginaForaDosLimites(indicePagina, getTotalPaginas());
        }

        int indiceMenor = indicePagina * maximoDeElementosPorPagina;
        int indiceMaior = indiceMenor + maximoDeElementosPorPagina;

        if (indiceMaior > getTotalElementos()) {
            indiceMaior = getTotalElementos();
        }
        List<T> elementosDaPagina = elementos.subList(indiceMenor, indiceMaior);

        boolean ultimaPagina = indicePagina == indiceMaximoDasPaginas();

        return new Pagina<>(elementosDaPagina, ultimaPagina, indicePagina);
    }

    @Override
    public int getTotalElementos() {
        return elementos.size();
    }

    @Override
    public int getTotalPaginas() {
//        int divisaoArredondadaParaBaixo = getTotalElementos() / getMaximoDeElementosPorPagina();
//        if (getTotalElementos() % getMaximoDeElementosPorPagina() == 0) {
//            return divisaoArredondadaParaBaixo;
//        }
//        return divisaoArredondadaParaBaixo + 1;

        if (getTotalElementos() == 0) {
            return 1;
        }

        BigDecimal totalDeElementos = BigDecimal.valueOf(getTotalElementos());
        BigDecimal maximoDeElementosPorPagina = BigDecimal.valueOf(getMaximoDeElementosPorPagina());
        BigDecimal totalDePaginas = totalDeElementos.divide(maximoDeElementosPorPagina, RoundingMode.CEILING);
        return totalDePaginas.intValue();
    }

    private int indiceMaximoDasPaginas() {
        return getTotalPaginas() - 1;
    }

    @Override
    public int getMaximoDeElementosPorPagina() {
        return maximoDeElementosPorPagina;
    }

}
