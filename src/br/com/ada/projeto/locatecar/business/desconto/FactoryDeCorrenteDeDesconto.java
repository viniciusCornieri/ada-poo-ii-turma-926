package br.com.ada.projeto.locatecar.business.desconto;

public class FactoryDeCorrenteDeDesconto {

    public static CorrenteDeCalculoDeDesconto criarCorrenteDeDesconto() {
        DescontoPessoaFisica descontoPessoaFisica = new DescontoPessoaFisica();
        DescontoPessoaJuridica descontoPessoaJuridica = new DescontoPessoaJuridica();

        descontoPessoaFisica.adicionaNovaValidacaoDeDesconto(descontoPessoaJuridica);

        return descontoPessoaFisica;
    }
}
