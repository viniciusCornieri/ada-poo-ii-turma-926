package br.com.ada.projeto.locatecar.business.desconto;

import br.com.ada.projeto.locatecar.model.Aluguel;

import java.math.BigDecimal;

/**
 * Essa classe utilizamos aplicar o Design Pattern Chain of responsibility
 * Aqui conseguiriamos ir adicionando novas regras de Desconto encadeadas
 * e funcionam independentes umas das outras.
 * Isso é uma das possíveis formas de mantermos o princípio do Open/Closed nesses cálculos.
 * @see <a href="https://www.baeldung.com/chain-of-responsibility-pattern">Chain of Responsibility</a>
 */
public abstract class CorrenteDeCalculoDeDesconto implements CalculadorDeDesconto {

    private CorrenteDeCalculoDeDesconto proximaValidacaoDeDesconto;
    public void adicionaNovaValidacaoDeDesconto(CorrenteDeCalculoDeDesconto correnteDeCalculoDeDesconto) {
        this.proximaValidacaoDeDesconto = correnteDeCalculoDeDesconto;
    }

    protected BigDecimal executaProximoCalculoDeDesconto(Aluguel aluguel) {
        if (proximaValidacaoDeDesconto != null) {
            return this.calculaDesconto(aluguel);
        }

        return BigDecimal.ZERO;
    }

}
