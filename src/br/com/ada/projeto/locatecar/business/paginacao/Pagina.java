package br.com.ada.projeto.locatecar.business.paginacao;

import java.util.List;

public record Pagina<T>(List<T> elementosDaPagina, boolean ultimaPagina, int indice) {
}
