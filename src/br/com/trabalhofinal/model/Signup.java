package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup extends Usuario {

  public Signup(String nome, String email, String senha) {
    super(nome, email, senha);
  }

  private final static String CONSULTA_EMAIL_EM_USO_QUERY = "SELECT email FROM usuario WHERE email = ?";
  private final static String INSERT_USUARIO_QUERY = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

  public static boolean emailEmUso(String email) {
    boolean emUso = false;

    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(CONSULTA_EMAIL_EM_USO_QUERY);
      pstmt.setString(1, email);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        emUso = true;
      }
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
    return emUso;
  }

  public void insereUsuario() {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(INSERT_USUARIO_QUERY);
      pstmt.setString(1, getNome());
      pstmt.setString(2, getEmail());
      pstmt.setString(3, getSenha());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
  }
}
