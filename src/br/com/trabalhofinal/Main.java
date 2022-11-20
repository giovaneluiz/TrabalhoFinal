package br.com.trabalhofinal;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) throws SQLException {
    String nome = JOptionPane.showInputDialog(null, "Informe seu nome");
    String email = JOptionPane.showInputDialog(null, "Informe seu email");
    String senha = JOptionPane.showInputDialog(null, "Informe seu senha");
    String confirmaSenha = JOptionPane.showInputDialog(null, "Repita a senha");
    
    CadastrarUsuario novoUsuario = new CadastrarUsuario(nome, email, senha);
    
    boolean confereSenha = novoUsuario.verificaSenha(confirmaSenha);
    boolean emailEmUso = novoUsuario.emailEmUso();
    
    if(emailEmUso == true){
      JOptionPane.showMessageDialog(null, "Email já cadastrado! Efetue o Login!");
    }else{
      if(confereSenha == true){
        novoUsuario.insereUsuario();
        JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
      }else{
        JOptionPane.showMessageDialog(null, "As senhas não conferem!");
      }
    }
  }
}
