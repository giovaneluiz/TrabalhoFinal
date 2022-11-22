package br.com.trabalhofinal.controller;

import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    private Usuario usuarioLogado;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("menu")) {
                    usuarioLogado = userData;
                }
            }
        });
    }

    @FXML
    private Button btnAddAmigo;

    @FXML
    private Button btnListaAmigos;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnRemoveAmigo;

    @FXML
    void addAmigo(ActionEvent event) {
        Main.changeScreen("add", usuarioLogado);
    }

    @FXML
    void listaAmigos(ActionEvent event) {
        Main.changeScreen("list", usuarioLogado);
    }

    @FXML
    void removeAmigo(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        Main.changeScreen("login", null);
    }

}
