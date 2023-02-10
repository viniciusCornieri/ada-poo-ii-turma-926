package br.com.ada.projeto.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MenuComSubmenus extends Submenu {

    private Map<String, Menu> submenus = new HashMap<>();

    public MenuComSubmenus(String descricao) {
        super(descricao);
    }

    @Override
    public void acao() {

        exibirSubmenus();

        Menu menu = selecionarMenu();

        menu.agir();

    }
    private void exibirSubmenus() {
        Set<String> chaves = submenus.keySet();
        for (String chave : chaves) {
            System.out.print("%s. ".formatted(chave));
            Menu menu = submenus.get(chave);
            menu.exibir();
        }
    }

    private Menu selecionarMenu() {
        Menu menu = null;
        do {
            String menuSelecionado = CapturadorDeEntrada.capturarString("o menu");
            menu = submenus.get(menuSelecionado);

            if (menu == null) {
                System.out.println("Entrada %s não é válida, tente novamente.".formatted(menuSelecionado));
            }
        } while (menu == null);
        return menu;
    }

    public void adicionarSubMenu(Menu menu) {
        int indice = submenus.size() + 1;
        submenus.put(String.valueOf(indice), menu);
    }
}
