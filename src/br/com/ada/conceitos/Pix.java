package br.com.ada.conceitos;

import java.math.BigDecimal;

public class Pix implements PixInterface {

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

    @Override
    public void validarChave(String chavePix) {
        // comunicacao com o servico de chaves;
    }

    @Override
    public void validarPixCopiaECola(String copiaECola) {
        //comunicacao com o sistema de qrCodes
    }

    @Override
    public void realizarPix() {
        // comunico com o banco central
    }
}
