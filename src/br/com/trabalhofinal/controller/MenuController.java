package br.com.trabalhofinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

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
        Main.changeScreen("add");
    }

    @FXML
    void listaAmigos(ActionEvent event) {

    }

    @FXML
    void removeAmigo(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        Main.changeScreen("login");
    }

}
