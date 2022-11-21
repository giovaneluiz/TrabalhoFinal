package br.com.trabalhofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastrarUsuario extends Usuario {

  public CadastrarUsuario(String nome, String email, String senha) {
    super(nome, email, senha);
  }

  public boolean verificaSenha(String confirmaSenha) {
    if (getSenha().equals(confirmaSenha)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean emailEmUso() {
    Connection conn = Conexao.connect();
    boolean emUso = false;

    try {
      PreparedStatement pstmt = conn.prepareStatement("SELECT email FROM usuario WHERE email = ?");
      pstmt.setString(1, getEmail());
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        conn.close();
        emUso = true;
      }

    } catch (SQLException e) {
      Conexao.printSQLException(e);
    }
    return emUso;
  }

  public void insereUsuario() throws SQLException {
    Connection conn = Conexao.connect();
    try {
      PreparedStatement pstmt = conn.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)");
      pstmt.setString(1, getNome());
      pstmt.setString(2, getEmail());
      pstmt.setString(3, getSenha());
      pstmt.executeUpdate();

    } catch (SQLException e) {
      Conexao.printSQLException(e);
    }
    conn.close();
  }

}
