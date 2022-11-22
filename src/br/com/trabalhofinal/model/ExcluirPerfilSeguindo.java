package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirPerfilSeguindo {
  private final static String DELETE_SEGUIDOR_QUERY = "DELETE FROM seguidor_usuario WHERE id_usuario_principal = ? AND id_usuario_seguindo = ?";

  public void excluirPerfil(int id_usuario_principal, int id_usuario_seguindo) {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(DELETE_SEGUIDOR_QUERY);
      pstmt.setInt(1, id_usuario_principal);
      pstmt.setInt(2, id_usuario_seguindo);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
  }
}