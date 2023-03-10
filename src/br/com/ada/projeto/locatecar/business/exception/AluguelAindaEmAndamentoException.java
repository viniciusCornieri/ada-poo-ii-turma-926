package br.com.ada.projeto.locatecar.business.exception;

public class AluguelAindaEmAndamentoException extends RuntimeException {

    public AluguelAindaEmAndamentoException() {
        super("O Aluguel ainda está em andamento não é possível fazer esse cálculo");
    }
}
