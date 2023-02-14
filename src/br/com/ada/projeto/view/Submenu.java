package br.com.ada.projeto.view;

public abstract class Submenu implements Menu {

    private static final String SEPARADOR = "-----------------------------------";

    private final String descricao;

    public Submenu(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void exibir() {
        System.out.println(descricao);
    }

    @Override
    public void agir() {
        exibirComSeparadores();

        acao();
    }

    public abstract void acao();

    private void exibirComSeparadores() {
        exibirSeparador();
        exibir();
        exibirSeparador();
    }

    protected static void exibirSeparador() {
        System.out.println(SEPARADOR);
    }

}
