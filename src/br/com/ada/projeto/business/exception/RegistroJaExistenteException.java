package br.com.ada.projeto.business.exception;

public class RegistroJaExistenteException extends RuntimeException {

    public RegistroJaExistenteException(String tipo, String id) {
        super("Já existe um registro do tipo %s com o id %s.".formatted(tipo, id));
    }
}
