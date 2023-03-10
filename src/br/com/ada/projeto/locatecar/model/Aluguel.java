package br.com.ada.projeto.locatecar.model;

import br.com.ada.projeto.locatecar.business.exception.AluguelAindaEmAndamentoException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Aluguel implements Entidade<UUID> {
    private UUID id;

    private Cliente cliente;

    private Veiculo veiculo;

    private BigDecimal tarifaRegistrada;

    private LocalDateTime dataRetirada;

    private LocalDateTime dataDevolucao;

    private StatusAluguel status;

    private BigDecimal desconto;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataRetirada) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.tarifaRegistrada = veiculo.getTipo().getTarifa();
        this.dataRetirada = dataRetirada;
        this.desconto = BigDecimal.ZERO;
        this.status = StatusAluguel.EM_ANDAMENTO;
    }

    public UUID getId() {
        return id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public long getDiarias() {
        if (dataDevolucao == null) {
            throw new AluguelAindaEmAndamentoException();
        }

        return Duration.between(dataRetirada, dataDevolucao).toDays() + 1;
    }

    public BigDecimal getValorBruto() {
        BigDecimal diarias = BigDecimal.valueOf(getDiarias());
        return tarifaRegistrada.multiply(diarias);
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorLiquido() {
        return getValorBruto().subtract(desconto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public boolean estaEmAndamento() {
        return StatusAluguel.EM_ANDAMENTO == status;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", tarifaRegistrada=" + tarifaRegistrada +
                ", dataRetirada=" + dataRetirada +
                ", dataDevolucao=" + dataDevolucao +
                ", status=" + status +
                '}';
    }
}
