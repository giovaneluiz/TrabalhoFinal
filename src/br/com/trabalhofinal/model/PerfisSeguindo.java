package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfisSeguindo {
  private ArrayList<PerfilUsuario> perfilUsuarios = new ArrayList<PerfilUsuario>();

  private final static String SELECT_PERFIL_QUERY = "SELECT U.id_usuario, TRIM(U.nome) AS nome, U.email FROM usuario U"
      + " INNER JOIN amizade S ON U.id_usuario = S.id_usuario_amigo"
      + " WHERE S.id_usuario_principal = ?"
      + " ORDER BY id_usuario";

  public ArrayList<PerfilUsuario> buscaPerfisSeguindo(int id_usuario_logado) {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(SELECT_PERFIL_QUERY);
      pstmt.setInt(1, id_usuario_logado);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        PerfilUsuario conta = new PerfilUsuario(
            rs.getInt("id_usuario"),
            rs.getString("nome"),
            rs.getString("email"));
        perfilUsuarios.add(conta);
      }
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
    return perfilUsuarios;
  }
}
