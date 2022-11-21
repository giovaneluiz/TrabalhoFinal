package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Usuario {

  public Login(String email, String senha) {
    super(email, senha);
  }

  private final static String LOGIN_QUERY = "SELECT email, TRIM(senha) AS senha FROM usuario WHERE email = ?";

  public boolean logar() {
    Connection conn = Conexao.connect();
    boolean logado = false;

    try {
      PreparedStatement pstmt = conn.prepareStatement(LOGIN_QUERY);
      pstmt.setString(1, getEmail());
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        String senhaBD = rs.getString("senha");
        if (senhaBD.equals(getSenha())) {
          logado = true;
        }
      }

    } catch (SQLException e) {
      Conexao.printSQLException(e);
    }
    Conexao.disconnect();
    return logado;
  }

}
