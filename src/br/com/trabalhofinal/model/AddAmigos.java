package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddAmigos {
  private ArrayList<ContaUsuario> contas = new ArrayList<>();

  private final static String SELECT_AMIGOS_QUERY = "SELECT id_usuario, nome, email FROM usuario WHERE id_usuario <> ?";
  private final static String INSERT_SEGUIDOR_QUERY = "INSERT INTO seguidor_usuario (id_usuario_principal, id_usuario_seguindo) VALUES (?, ?)";

  public ArrayList<ContaUsuario> getContaUsuarios() {
    return contas;
  }

  public void setContaUsuarios(ArrayList<ContaUsuario> contas) {
    this.contas = contas;
  }

  public ArrayList<ContaUsuario> buscaAmigosParaSeguir() {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(SELECT_AMIGOS_QUERY);
      pstmt.setInt(1, 0);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        while (rs.next()) {
          ContaUsuario conta = new ContaUsuario(
              rs.getInt("id_usuario"),
              rs.getString("nome"),
              rs.getString("email"));
          contas.add(conta);
        }
      }
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
    return contas;
  }

  public void seguirConta(int id_usuario_principal, int id_usuario_seguindo) {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(INSERT_SEGUIDOR_QUERY);
      pstmt.setInt(1, id_usuario_principal);
      pstmt.setInt(2, id_usuario_seguindo);
      pstmt.execute();

    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
  }

}
