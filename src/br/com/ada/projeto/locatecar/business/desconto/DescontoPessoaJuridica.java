package br.com.ada.projeto.locatecar.business.desconto;

import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.TipoCliente;

import java.math.BigDecimal;

public class DescontoPessoaJuridica extends CorrenteDeCalculoDeDesconto {

    @Override
    public BigDecimal calculaDesconto(Aluguel aluguel) {
        boolean ehPessoaJuridica = aluguel.getCliente().getTipoCliente() == TipoCliente.PESSOA_JURIDICA;
        if (ehPessoaJuridica && aluguel.getDiarias() > 3) {
            BigDecimal cincoPorcento = BigDecimal.valueOf(0.10);
            return aluguel.getValorBruto().multiply(cincoPorcento);
        }

        return executaProximoCalculoDeDesconto(aluguel);
    }
}
