package br.com.trabalhofinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("menu")) {

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
        Main.changeScreen("add", null);
    }

    @FXML
    void listaAmigos(ActionEvent event) {

    }

    @FXML
    void removeAmigo(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        Main.changeScreen("login", null);
    }

}
