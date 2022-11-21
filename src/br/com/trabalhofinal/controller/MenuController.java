package br.com.trabalhofinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button btnLogout;

    @FXML
    void logout(ActionEvent event) {
        Main.changeScreen("login");
    }

}
