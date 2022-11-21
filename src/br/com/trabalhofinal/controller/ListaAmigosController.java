package br.com.trabalhofinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListaAmigosController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnVoltar;

    @FXML
    void addAmigo(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", null);
    }

}
