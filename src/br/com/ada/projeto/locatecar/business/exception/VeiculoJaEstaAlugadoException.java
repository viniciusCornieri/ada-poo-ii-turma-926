package br.com.ada.projeto.locatecar.business.exception;

import br.com.ada.projeto.locatecar.model.Veiculo;

public class VeiculoJaEstaAlugadoException extends RuntimeException {

    public VeiculoJaEstaAlugadoException(Veiculo veiculo) {
        super("%s já está alugado".formatted(veiculo));
    }
}
