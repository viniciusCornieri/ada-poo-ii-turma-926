package br.com.ada.projeto.locatecar.view;

public class MenuEncerrar extends Submenu {
    public MenuEncerrar() {
        super("Encerrar");
    }

    @Override
    public void acao() {
        System.out.println("Encerrado!");
        System.exit(0);
    }
}
