package br.com.ada.conceitos;

import java.math.BigDecimal;

public class InternetBanking {

    private EnviadorDeNotificacao enviadorDeNotificacao;

    public void fazerTED(Conta conta, BigDecimal valor) {
        conta.debito(valor);
        enviadorDeNotificacao.enviarPushNotification("TED feito com sucesso");
    }

}
