package br.com.trabalhofinal.model;

import br.com.trabalhofinal.model.interfaces.AdicionarAmigo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdicionaAmigo implements AdicionarAmigo {
  private ArrayList<PerfilUsuario> perfilUsuarios = new ArrayList<PerfilUsuario>();

  private final static String SELECT_PERFIL_QUERY = "SELECT id_usuario, TRIM(nome) AS nome, email FROM usuario"
      + " WHERE id_usuario NOT IN ("
      + " SELECT id_usuario_amigo from amizade where id_usuario_principal = ?"
      + " ) AND id_usuario <> ?"
      + " ORDER BY id_usuario";

  private final static String INSERT_AMIZADE_QUERY = "INSERT INTO amizade (id_usuario_principal, id_usuario_amigo) VALUES (?, ?)";

  public ArrayList<PerfilUsuario> buscaPerfilUsuarioParaAdicionar(int id_usuario_logado) {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(SELECT_PERFIL_QUERY);
      pstmt.setInt(1, id_usuario_logado);
      pstmt.setInt(2, id_usuario_logado);
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

  public void adicionar(int id_usuario_principal, int id_usuario_amigo) {
    try {
      Connection conn = Conexao.connect();
      PreparedStatement pstmt = conn.prepareStatement(INSERT_AMIZADE_QUERY);
      pstmt.setInt(1, id_usuario_principal);
      pstmt.setInt(2, id_usuario_amigo);
      pstmt.execute();
      pstmt = conn.prepareStatement(INSERT_AMIZADE_QUERY);
      pstmt.setInt(1, id_usuario_amigo);
      pstmt.setInt(2, id_usuario_principal);
      pstmt.execute();

    } catch (SQLException e) {
      Conexao.printSQLException(e);
    } finally {
      Conexao.disconnect();
    }
  }

}
