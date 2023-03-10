package br.com.ada.projeto.locatecar.model;

import java.io.Serial;

public class ClientePessoaJuridica extends Cliente {

    @Serial
    private static final long serialVersionUID = 1L;
    private String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) {
        super(nome, TipoCliente.PESSOA_JURIDICA);
        this.cnpj = cnpj;
    }

    @Override
    public String getId() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "ClientePessoaJuridica{" +
                "cnpj='" + cnpj + "'," +
                "nome='" + getNome() + "'," +
                "tipoCliente='" + getTipoCliente() + "'" +
                '}';
    }

}
