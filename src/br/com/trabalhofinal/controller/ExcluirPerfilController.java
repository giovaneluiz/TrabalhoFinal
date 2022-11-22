package br.com.trabalhofinal.controller;

import java.util.ArrayList;
import java.util.Optional;

import br.com.trabalhofinal.model.ExcluirPerfilSeguindo;
import br.com.trabalhofinal.model.PerfilUsuario;
import br.com.trabalhofinal.model.PerfisSeguindo;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class ExcluirPerfilController {
    private Usuario usuarioLogado;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewPerfisSeguindo;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("excluir")) {
                    usuarioLogado = userData;
                    updateList();
                }
            }
        });
    }

    @FXML
    void excluirUsuario(ActionEvent event) {
        PerfilUsuario perfilUsuario = viewPerfisSeguindo.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Deixar de seguir usuário");
        alert.setHeaderText("Deseja parar de seguir o usuário " + perfilUsuario.getNome() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            ExcluirPerfilSeguindo excluirPerfil = new ExcluirPerfilSeguindo();
            excluirPerfil.excluirPerfil(usuarioLogado.getId(), perfilUsuario.getId());
            Main.changeScreen("menu", usuarioLogado);
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void updateList() {
        viewPerfisSeguindo.getItems().clear();
        PerfisSeguindo seguindo = new PerfisSeguindo();
        ArrayList<PerfilUsuario> contas = seguindo.buscaPerfisSeguindo(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewPerfisSeguindo.getItems().add(contaUsuario);
        }
    }

}
