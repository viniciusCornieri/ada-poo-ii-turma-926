package br.com.ada.projeto.locatecar.business.desconto;

import br.com.ada.projeto.locatecar.model.Aluguel;

import java.math.BigDecimal;

public interface CalculadorDeDesconto {

    BigDecimal calculaDesconto(Aluguel aluguel);

}
