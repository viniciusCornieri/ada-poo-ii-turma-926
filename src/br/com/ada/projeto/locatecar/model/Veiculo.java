package br.com.ada.projeto.locatecar.model;

public class Veiculo implements Entidade<String> {

    private String placa;
    private String modelo;
    private boolean disponivel;
    private TipoVeiculo tipo;

    public Veiculo(String placa, String modelo, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponivel = true;
    }


    @Override
    public String getId() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", disponivel=" + disponivel +
                ", tipo=" + tipo +
                '}';
    }
}
