package br.com.trabalhofinal.controller;

import java.util.ArrayList;

import br.com.trabalhofinal.model.PerfilUsuario;
import br.com.trabalhofinal.model.PerfisSeguindo;
import br.com.trabalhofinal.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PerfisSeguindoController {
    private Usuario usuarioLogado;

    @FXML
    private Button btnVoltar;

    @FXML
    private ListView<PerfilUsuario> viewPerfisSeguindo;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Usuario userData) {
                if (newScreen.equals("list")) {
                    usuarioLogado = userData;
                    updateList();
                }
            }
        });
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
