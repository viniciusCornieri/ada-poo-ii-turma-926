package br.com.ada.projeto.locatecar.model;

import java.io.Serial;

public abstract class Cliente implements Entidade<String> {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;

    private final TipoCliente tipoCliente;

    public Cliente(String nome, TipoCliente tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
