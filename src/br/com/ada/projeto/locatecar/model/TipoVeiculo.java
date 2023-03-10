package br.com.ada.projeto.locatecar.model;

import java.io.Serial;
import java.math.BigDecimal;

public class TipoVeiculo implements Entidade<String> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String descricao;

    private BigDecimal tarifa;

    public TipoVeiculo(String descricao, BigDecimal tarifa) {
        this.descricao = descricao;
        this.tarifa = tarifa;
    }

    @Override
    public String getId() {
        return descricao;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "TipoVeiculo{" +
                "descricao='" + descricao + '\'' +
                ", tarifa=" + tarifa +
                '}';
    }
}
