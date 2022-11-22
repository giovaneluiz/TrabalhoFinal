package br.com.trabalhofinal.controller;

import java.util.ArrayList;

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

    Parent fxmlAddAmigos = FXMLLoader.load(getClass().getResource("../view/addAmigos.fxml"));
    addAmigoScene = new Scene(fxmlAddAmigos);

    primaryStage.setTitle("Login - Conecta Newton");
    primaryStage.setScene(loginScene);
    primaryStage.show();
  }

  public static void changeScreen(String src, Object userData) {
    switch (src) {
      case "login":
        stage.setTitle("Login - Conecta Newton");
        stage.setScene(loginScene);
        notifyAllListeners("login", userData);
        break;
      case "signup":
        stage.setTitle("Criar Conta - Conecta Newton");
        stage.setScene(signupScene);
        notifyAllListeners("signup", userData);
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
    }
  }

  private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

  public static interface OnChangeScreen {
    void onScreenChanged(String newScreen, Object userData);
  }

  public static void addOnChangeScreenListener(OnChangeScreen newListener) {
    listeners.add(newListener);
  }

  public static void notifyAllListeners(String newScreen, Object userData) {
    for (OnChangeScreen onChangeScreen : listeners) {
      onChangeScreen.onScreenChanged(newScreen, userData);
    }
  }
}
