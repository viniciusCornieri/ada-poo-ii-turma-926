package br.com.ada.conceitos;

import java.math.BigDecimal;

public class Pix {

    private EnviadorDeNotificacao enviadorDeNotificacao;

    public void enviarPix(Conta conta, BigDecimal valor, String chavePix) {
        verificarChavePix(chavePix);
        conta.debito(valor);
//        enviarMensagemParaBancoCentral();
        enviadorDeNotificacao.enviarPushNotification("Pix Enviado com sucesso");
    }

    public boolean verificarChavePix(String chavePix) {
        return true;
    }
}
