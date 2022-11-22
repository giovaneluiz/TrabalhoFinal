package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddAmigos {
  private ArrayList<PerfilUsuario> perfilUsuarios = new ArrayList<PerfilUsuario>();

  private final static String SELECT_PERFIL_QUERY = "SELECT id_usuario, nome, email FROM usuario WHERE id_usuario <> ?";
  private final static String INSERT_SEGUIDOR_QUERY = "INSERT INTO seguidor_usuario (id_usuario_principal, id_usuario_seguindo) VALUES (?, ?)";

  public ArrayList<PerfilUsuario> getContaUsuarios() {
    return perfilUsuarios;
  }

  public void setContaUsuarios(ArrayList<PerfilUsuario> perfilUsuarios) {
    this.perfilUsuarios = perfilUsuarios;
  }

  public ArrayList<PerfilUsuario> buscaAmigosParaSeguir() {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(SELECT_PERFIL_QUERY);
      pstmt.setInt(1, 0);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        while (rs.next()) {
          PerfilUsuario conta = new PerfilUsuario(
              rs.getInt("id_usuario"),
              rs.getString("nome"),
              rs.getString("email"));
          perfilUsuarios.add(conta);
        }
      }
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
    return perfilUsuarios;
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
