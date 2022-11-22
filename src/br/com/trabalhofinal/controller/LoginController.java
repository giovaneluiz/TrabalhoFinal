package br.com.trabalhofinal.controller;

import br.com.trabalhofinal.model.Login;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
  private void initialize() {

    Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

      @Override
      public void onScreenChanged(String newScreen, Usuario userData) {
        if (newScreen.equals("login")) {
          txtEmail.setText("");
          txtSenha.setText("");
        }
      }
    });
  }

  @FXML
  protected void login(ActionEvent event) {
    if (this.txtEmail.getText().isEmpty() || this.txtSenha.getText().isEmpty()) {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Error!");
      alert.setHeaderText("Informe o usuário e senha para fazer login!");
      alert.showAndWait();
    } else {
      Login novoLogin = new Login(this.txtEmail.getText(), this.txtSenha.getText());
      if (novoLogin.logar() == true) {
        Main.changeScreen("menu", novoLogin);
      } else {
        this.txtSenha.setText(null);
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error!");
        alert.setHeaderText("Erro ao fazer Login! \nUsuário ou senha incorretos.");
        alert.showAndWait();
      }
    }
  }

  @FXML
  void criarConta(ActionEvent event) {
    Main.changeScreen("signup", null);
  }
}
