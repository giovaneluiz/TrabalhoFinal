package br.com.trabalhofinal.model;

import br.com.trabalhofinal.model.interfaces.ListarAmigos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaAmigos implements ListarAmigos {
  private ArrayList<PerfilUsuario> perfilUsuarios = new ArrayList<PerfilUsuario>();

  private final static String SELECT_PERFIL_QUERY = "SELECT U.id_usuario, TRIM(U.nome) AS nome, U.email FROM usuario U"
      + " WHERE id_usuario IN (SELECT id_usuario_amigo FROM amizade WHERE id_usuario_principal = ?)"
      + " ORDER BY id_usuario";

  public ArrayList<PerfilUsuario> busca(int id_usuario_logado) {
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
