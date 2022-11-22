package br.com.trabalhofinal.controller;

import java.util.ArrayList;
import java.util.Optional;

import br.com.trabalhofinal.model.AddAmigos;
import br.com.trabalhofinal.model.ContaUsuario;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class AddAmigosController {
    private Usuario usuarioLogado;

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
    private Button btnAdd;

    @FXML
    private Button btnVoltar;

    @FXML
    void addAmigo(ActionEvent event) {
        ContaUsuario usuario = viewAmigos.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de amizade");
        alert.setHeaderText("Seguir usuário " + usuario.getNome() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            AddAmigos seguirNovo = new AddAmigos();
            seguirNovo.seguirConta(usuarioLogado.getId(), usuario.getId());
            Main.changeScreen("menu", usuarioLogado);
        }
    }

    @FXML
    private ListView<ContaUsuario> viewAmigos;

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", null);
    }

    private void updateList() {
        viewAmigos.getItems().clear();
        AddAmigos addAmigos = new AddAmigos();
        ArrayList<ContaUsuario> contas = addAmigos.buscaAmigosParaSeguir();
        for (ContaUsuario contaUsuario : contas) {
            viewAmigos.getItems().add(contaUsuario);
        }
    }

}
