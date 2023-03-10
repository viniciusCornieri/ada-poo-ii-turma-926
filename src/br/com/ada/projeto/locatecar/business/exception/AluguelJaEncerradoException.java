package br.com.ada.projeto.locatecar.business.exception;

import br.com.ada.projeto.locatecar.model.Aluguel;

public class AluguelJaEncerradoException extends RuntimeException {

    public AluguelJaEncerradoException(Aluguel aluguel) {
        super("%s já está encerrado".formatted(aluguel));
    }

}
