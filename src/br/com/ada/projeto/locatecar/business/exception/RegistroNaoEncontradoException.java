package br.com.ada.projeto.locatecar.business.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(String tipo, String id) {
        super("Não existe um registro do tipo %s com o id %s.".formatted(tipo, id));
    }
}
