package br.com.trabalhofinal.controller;

import java.util.ArrayList;
import java.util.Optional;

import br.com.trabalhofinal.model.RemoveAmigo;
import br.com.trabalhofinal.model.PerfilUsuario;
import br.com.trabalhofinal.model.ListaAmigos;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class ExcluirAmigoController {
    private Usuario usuarioLogado;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewAmizades;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("excluir")) {
                    usuarioLogado = userData;
                    carregaLista();
                }
            }
        });
    }

    @FXML
    void excluirUsuario(ActionEvent event) {
        PerfilUsuario perfilUsuario = viewAmizades.getSelectionModel().getSelectedItem();
        if (perfilUsuario != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Desfazer amizade");
            alert.setHeaderText("Deseja desfazer a amizade com o usuário " + perfilUsuario.getNome() + "?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                RemoveAmigo amigo = new RemoveAmigo();
                amigo.desfazerAmizade(usuarioLogado.getId(), perfilUsuario.getId());
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Desfazer amizade");
                alert.setHeaderText("Você e o usuário " + perfilUsuario.getNome() + ", não são mais amigos!");
                alert.show();
                carregaLista();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Desfazer amizade");
            alert.setHeaderText("É necessário selecionar um usuário para desfazer a amizade!");
            alert.show();
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Main.changeScreen("menu", usuarioLogado);
    }

    private void carregaLista() {
        viewAmizades.getItems().clear();
        ListaAmigos seguindo = new ListaAmigos();
        ArrayList<PerfilUsuario> contas = seguindo.busca(usuarioLogado.getId());
        for (PerfilUsuario contaUsuario : contas) {
            viewAmizades.getItems().add(contaUsuario);
        }
    }

}
