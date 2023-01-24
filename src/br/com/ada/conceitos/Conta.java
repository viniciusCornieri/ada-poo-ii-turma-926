package br.com.ada.conceitos;

import java.math.BigDecimal;

public class Conta {

    public void debito(BigDecimal valor) {
        verificarSaldo();
        verificarLogin();
        subtrairValor(valor);
        adicionarNoExtrato(valor);
        fazerProcessoContabil();
    }

    private void fazerProcessoContabil() {
    }

    private void adicionarNoExtrato(BigDecimal valor) {
        
    }

    private boolean verificarSaldo() {
        return true;
    }
    private boolean verificarLogin() {
        return true;
    }

    private void subtrairValor(BigDecimal valor) {

    }

}
