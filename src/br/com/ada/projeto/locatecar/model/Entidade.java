package br.com.ada.projeto.locatecar.model;

import java.io.Serializable;

public interface Entidade<T> extends Serializable {

    T getId();
}
