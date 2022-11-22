package br.com.trabalhofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddAmigos {
  private ArrayList<ContaUsuario> contas = new ArrayList<>();

  private final static String SELECT_AMIGOS_QUERY = "SELECT id_usuario, nome, email FROM usuario WHERE id_usuario <> ?";

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

  public void addConta(ContaUsuario conta) {
    contas.add(conta);
  }

}
