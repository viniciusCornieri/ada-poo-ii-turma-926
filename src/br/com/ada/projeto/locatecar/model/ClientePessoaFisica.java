package br.com.ada.projeto.locatecar.model;

public class ClientePessoaFisica extends Cliente {

    private String cpf;

    public ClientePessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    @Override
    public String toString() {
        return "ClientePessoaFisica{" +
                "cpf='" + cpf + "'," +
                "nome='" + getNome() + '\'' +
                '}';
    }
}
