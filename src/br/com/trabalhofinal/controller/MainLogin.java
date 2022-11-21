package br.com.trabalhofinal.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application {
  private static Stage stage;
  private static Scene loginScene;
  private static Scene signupScene;

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
    }
  }
}
