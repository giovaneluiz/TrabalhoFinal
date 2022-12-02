package br.com.trabalhofinal.controller;

import java.util.ArrayList;

import br.com.trabalhofinal.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  private static Stage stage;
  private static Scene loginScene;
  private static Scene signupScene;
  private static Scene menuScene;
  private static Scene addAmigoScene;
  private static Scene listSeguindoScene;
  private static Scene excluirSeguindoScene;

  public static Usuario usuarioLogado = null;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;

    Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
    loginScene = new Scene(fxmlLogin);

    Parent fxmlSignup = FXMLLoader.load(getClass().getResource("../view/signup.fxml"));
    signupScene = new Scene(fxmlSignup);

    Parent fxmlMenu = FXMLLoader.load(getClass().getResource("../view/menu.fxml"));
    menuScene = new Scene(fxmlMenu);

    Parent fxmlAdicionarAmigo = FXMLLoader.load(getClass().getResource("../view/adicionar-amigo.fxml"));
    addAmigoScene = new Scene(fxmlAdicionarAmigo);

    Parent fxmlListarAmigos = FXMLLoader.load(getClass().getResource("../view/listar-amigos.fxml"));
    listSeguindoScene = new Scene(fxmlListarAmigos);

    Parent fxmlExcluirAmigos = FXMLLoader.load(getClass().getResource("../view/excluir-amigo.fxml"));
    excluirSeguindoScene = new Scene(fxmlExcluirAmigos);

    primaryStage.setTitle("Login - Conecta Newton");
    primaryStage.setScene(loginScene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void changeScreen(String src, Usuario userData) {
    switch (src) {
      case "login":
        stage.setTitle("Login - Conecta Newton");
        stage.setScene(loginScene);
        notifyAllListeners("login", userData);
        break;
      case "signup":
        stage.setTitle("Criar Conta - Conecta Newton");
        stage.setScene(signupScene);
        notifyAllListeners("signup", null);
        break;
      case "menu":
        stage.setTitle("Menu Principal - Conecta Newton");
        stage.setScene(menuScene);
        notifyAllListeners("menu", userData);
        break;
      case "add":
        stage.setTitle("Adicionar Amigos - Conecta Newton");
        stage.setScene(addAmigoScene);
        notifyAllListeners("add", userData);
        break;
      case "list":
        stage.setTitle("Usuários que estou seguindo - Conecta Newton");
        stage.setScene(listSeguindoScene);
        notifyAllListeners("list", userData);
        break;
      case "excluir":
        stage.setTitle("Remover usuários que estou seguindo - Conecta Newton");
        stage.setScene(excluirSeguindoScene);
        notifyAllListeners("excluir", userData);
        break;
    }
  }

  private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

  public static interface OnChangeScreen {
    void onScreenChanged(String newScreen, Usuario userData);
  }

  public static void addOnChangeScreenListener(OnChangeScreen newListener) {
    listeners.add(newListener);
  }

  public static void notifyAllListeners(String newScreen, Usuario userData) {
    for (OnChangeScreen onChangeScreen : listeners) {
      onChangeScreen.onScreenChanged(newScreen, userData);
    }
  }
}
