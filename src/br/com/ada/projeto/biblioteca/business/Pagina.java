package br.com.ada.projeto.biblioteca.business;

import java.util.List;

public record Pagina<T>(List<T> elementosDaPagina, boolean ultimaPagina, int indice) {
}
