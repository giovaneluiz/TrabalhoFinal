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
  protected void login(ActionEvent event) {
    Login novoLogin = new Login(this.txtEmail.getText(), this.txtSenha.getText());
    if (novoLogin.logar()) {
      Main.changeScreen("menu");
    } else {
      JOptionPane.showMessageDialog(null, "usuário ou senha incorretos");
    }
  }

  @FXML
  void criarConta(ActionEvent event) {
    Main.changeScreen("signup");
  }
}
