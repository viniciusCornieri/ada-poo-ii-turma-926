package br.com.ada.projeto.locatecar.view.cliente.pessoajuridica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaJuridica;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuDeletarClienteJuridica extends Submenu {

    private final GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica;

    public MenuDeletarClienteJuridica(GerenciadorDeClientePessoaJuridica gerenciadorDeClientePessoaJuridica) {
        super("Deletar " + gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaJuridica = gerenciadorDeClientePessoaJuridica;
    }

    @Override
    public void acao() {
        String cnpj = CapturadorDeEntrada.capturarString("o cnpj");

        boolean foiDeletado = gerenciadorDeClientePessoaJuridica.deletar(cnpj);

        if (foiDeletado) {
            System.out.println(gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade() + " deletado com sucesso!");
        } else {
            System.out.printf("Não foi encontrado um %s com esse cnpj para deletar.", gerenciadorDeClientePessoaJuridica.getDescricaoDaEntidade());
        }
    }
}
