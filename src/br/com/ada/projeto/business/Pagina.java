package br.com.ada.projeto.business;

import java.util.List;

public record Pagina<T>(List<T> elementosDaPagina, boolean ultimaPagina, int indice) {
}
