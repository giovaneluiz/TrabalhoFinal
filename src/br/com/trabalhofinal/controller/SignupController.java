package br.com.trabalhofinal.controller;

import java.sql.SQLException;

import br.com.trabalhofinal.model.Signup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    void signup(ActionEvent event) throws SQLException {
        if (this.txtNome.getText().isEmpty() || this.txtEmail.getText().isEmpty() || this.txtSenha.getText().isEmpty()
                || this.txtConfirmaSenha.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Preencha todos os dados antes de prosseguir!");
            alert.showAndWait();
        } else {
            Signup novoUsuario = new Signup(this.txtNome.getText(), this.txtEmail.getText(), this.txtSenha.getText());

            boolean confereSenha = novoUsuario.verificaSenha(this.txtConfirmaSenha.getText());
            boolean emailEmUso = novoUsuario.emailEmUso();

            if (emailEmUso) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Email em uso!");
                alert.setHeaderText("Email já cadastrado, efetue o Login!!");
                alert.showAndWait();
                Main.changeScreen("login");
            } else {
                if (!confereSenha) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Error!");
                    alert.setHeaderText("As senhas digitadas não conferem!");
                    alert.showAndWait();
                    this.txtSenha.setText("");
                    this.txtConfirmaSenha.setText("");
                } else {
                    novoUsuario.insereUsuario();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Usuário cadastrado com sucesso!");
                    alert.setContentText("Agora é só fazer o Login e interagir com vários usuários!");
                    alert.showAndWait();
                    Main.changeScreen("login");
                }
            }
        }

    }

}
