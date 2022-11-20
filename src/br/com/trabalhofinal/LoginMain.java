package br.com.trabalhofinal;

import javax.swing.JOptionPane;

public class LoginMain {
  public static void main(String[] args) {
    String email = JOptionPane.showInputDialog(null, "Informe seu email");
    String senha = JOptionPane.showInputDialog(null, "Informe seu senha");

    Login loginUsuario = new Login(email, senha);
    boolean logado = loginUsuario.logar();

    if (logado == true) {
      JOptionPane.showMessageDialog(null, "Login Efetuado!");
    } else {
      JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
    }
  }
}
