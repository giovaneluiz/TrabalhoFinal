package br.com.trabalhofinal.controller;

import javax.swing.JOptionPane;

import br.com.trabalhofinal.model.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

  @FXML
  private Button btnCriarConta;

  @FXML
  private Button btnLogin;

  @FXML
  private TextField txtEmail;

  @FXML
  private PasswordField txtSenha;

  @FXML
  void login(ActionEvent event) {

  }

  @FXML
  void criarConta(ActionEvent event) {
    MainLogin.changeScreen("signup");
  }
}
