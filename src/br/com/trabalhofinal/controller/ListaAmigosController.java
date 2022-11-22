package br.com.trabalhofinal.controller;

import java.util.ArrayList;

import br.com.trabalhofinal.model.AddAmigos;
import br.com.trabalhofinal.model.ContaUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ListaAmigosController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnVoltar;

    @FXML
    private void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {

            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("add")) {
                    updateList();
                }
            }
        });
    }

    @FXML
    void addAmigo(ActionEvent event) {

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
