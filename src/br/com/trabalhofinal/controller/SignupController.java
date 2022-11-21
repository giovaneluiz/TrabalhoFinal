package br.com.trabalhofinal.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.trabalhofinal.model.Sigup;
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
    void signup(ActionEvent event) throws SQLException {
        Sigup novoUsuario = new Sigup(this.txtNome.getText(), this.txtEmail.getText(), this.txtSenha.getText());

        boolean confereSenha = novoUsuario.verificaSenha(this.txtConfirmaSenha.getText());
        boolean emailEmUso = novoUsuario.emailEmUso();

        if (emailEmUso) {
            JOptionPane.showMessageDialog(null, "Email já cadastrado, efetue o Login!");
            Main.changeScreen("login");
        } else {
            if (confereSenha) {
                novoUsuario.insereUsuario();
                JOptionPane.showMessageDialog(null,
                        "Usuário cadastrado com sucesso! Agora é só fazer o Login e interagir com vários usuários!");
                Main.changeScreen("login");
            } else {
                JOptionPane.showMessageDialog(null, "As senhas digitadas não conferem!");
                this.txtSenha.setText("");
                this.txtConfirmaSenha.setText("");
            }
        }
    }

}
