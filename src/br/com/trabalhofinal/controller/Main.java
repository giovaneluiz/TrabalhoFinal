package br.com.trabalhofinal.controller;

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

    primaryStage.setTitle("Login - Conecta Newton");
    primaryStage.setScene(loginScene);
    primaryStage.show();
  }

  public static void changeScreen(String src) {
    switch (src) {
      case "login":
        stage.setScene(loginScene);
        break;
      case "signup":
        stage.setTitle("Criar Conta - Conecta Newton");
        stage.setScene(signupScene);
        break;
      case "menu":
        stage.setTitle("menu");
        stage.setScene(menuScene);
        break;
    }
  }
}
