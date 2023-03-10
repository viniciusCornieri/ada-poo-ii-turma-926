package br.com.ada.projeto.locatecar.business.desconto;

import br.com.ada.projeto.locatecar.model.Aluguel;
import br.com.ada.projeto.locatecar.model.TipoCliente;

import java.math.BigDecimal;

public class DescontoPessoaFisica extends CorrenteDeCalculoDeDesconto {

    @Override
    public BigDecimal calculaDesconto(Aluguel aluguel) {
        boolean ehPessoaFisica = aluguel.getCliente().getTipoCliente() == TipoCliente.PESSOA_FISICA;
        if (ehPessoaFisica && aluguel.getDiarias() > 5) {
            BigDecimal cincoPorcento = BigDecimal.valueOf(0.05);
            return aluguel.getValorBruto().multiply(cincoPorcento);
        }

        return executaProximoCalculoDeDesconto(aluguel);
    }
}
