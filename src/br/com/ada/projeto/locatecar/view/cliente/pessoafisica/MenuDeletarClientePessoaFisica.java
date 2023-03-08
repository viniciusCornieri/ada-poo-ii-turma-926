package br.com.ada.projeto.locatecar.view.cliente.pessoafisica;

import br.com.ada.projeto.locatecar.business.GerenciadorDeClientePessoaFisica;
import br.com.ada.projeto.locatecar.business.GerenciadorDeVeiculo;
import br.com.ada.projeto.locatecar.view.CapturadorDeEntrada;
import br.com.ada.projeto.locatecar.view.Submenu;

public class MenuDeletarClientePessoaFisica extends Submenu {

    private final GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica;

    public MenuDeletarClientePessoaFisica(GerenciadorDeClientePessoaFisica gerenciadorDeClientePessoaFisica) {
        super("Deletar " + gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
        this.gerenciadorDeClientePessoaFisica = gerenciadorDeClientePessoaFisica;
    }

    @Override
    public void acao() {
        String cpf = CapturadorDeEntrada.capturarString("o cpf");

        boolean foiDeletado = gerenciadorDeClientePessoaFisica.deletar(cpf);

        if (foiDeletado) {
            System.out.println(gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade() + " deletado com sucesso!");
        } else {
            System.out.printf("Não foi encontrado um %s com esse cpf para deletar.", gerenciadorDeClientePessoaFisica.getDescricaoDaEntidade());
        }
    }
}
