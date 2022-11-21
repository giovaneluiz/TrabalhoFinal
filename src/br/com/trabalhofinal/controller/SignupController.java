package br.com.trabalhofinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private Button btnRetornar;

    @FXML
    private Button btnSignup;

    @FXML
    private PasswordField txtConfirmaSenha;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void retornar(ActionEvent event) {
        Main.changeScreen("login");
    }

    @FXML
    void signup(ActionEvent event) {

    }

}
