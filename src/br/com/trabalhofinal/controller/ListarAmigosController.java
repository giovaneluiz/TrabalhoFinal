package br.com.trabalhofinal.controller;

import java.util.ArrayList;

import br.com.trabalhofinal.model.PerfilUsuario;
import br.com.trabalhofinal.model.ListarAmigos;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ListarAmigosController {
    private Usuario usuarioLogado;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewAmizades;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("list")) {
                    usuarioLogado = userData;
                    carregaLista();
                }
            }
        });
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void carregaLista() {
        viewAmizades.getItems().clear();
        ListarAmigos seguindo = new ListarAmigos();
        ArrayList<PerfilUsuario> contas = seguindo.buscaAmizades(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewAmizades.getItems().add(contaUsuario);
        }
    }

}
