package br.com.ada.projeto.locatecar.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Aluguel implements Entidade<UUID> {
    private UUID id;
    private Cliente cliente;
    private Veiculo veiculo;

    private BigDecimal tarifaRegistrada;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucaoPrevista;
    private LocalDateTime dataDevolucaoEfetiva;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataRetirada, LocalDateTime dataDevolucaoPrevista) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.tarifaRegistrada = veiculo.getTipo().getTarifa();
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", tarifaRegistrada=" + tarifaRegistrada +
                ", dataRetirada=" + dataRetirada +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoEfetiva=" + dataDevolucaoEfetiva +
                '}';
    }
}
