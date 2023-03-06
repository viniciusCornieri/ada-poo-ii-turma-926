package br.com.ada.projeto.locatecar.model;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;

    public ClientePessoaJuridica(String nome, String cnpj) {
        super(nome);
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
                "nome='" + getNome() + '\'' +
                '}';
    }

}
