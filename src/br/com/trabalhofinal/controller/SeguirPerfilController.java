package br.com.trabalhofinal.controller;

import java.util.ArrayList;
import java.util.Optional;

import br.com.trabalhofinal.model.SeguirPerfil;
import br.com.trabalhofinal.model.PerfilUsuario;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class SeguirPerfilController {
    private Usuario usuarioLogado;

    @FXML
    private Button btnSeguir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewAmigos;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("add")) {
                    usuarioLogado = userData;
                    updateList();
                }
            }
        });
    }

    @FXML
    void seguirUsuario(ActionEvent event) {
        PerfilUsuario perfilUsuario = viewAmigos.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de amizade");
        alert.setHeaderText("Seguir usuário " + perfilUsuario.getNome() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            SeguirPerfil seguirNovo = new SeguirPerfil();
            seguirNovo.seguirConta(usuarioLogado.getId(), perfilUsuario.getId());
            Main.changeScreen("menu", usuarioLogado);
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void updateList() {
        viewAmigos.getItems().clear();
        SeguirPerfil addAmigos = new SeguirPerfil();
        ArrayList<PerfilUsuario> contas = addAmigos.buscaPerfilParaSeguir(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewAmigos.getItems().add(contaUsuario);
        }
    }

}
