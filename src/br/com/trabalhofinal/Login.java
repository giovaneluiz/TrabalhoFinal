package br.com.trabalhofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Usuario {

  public Login(String email, String senha) {
    super(email, senha);
  }

  public boolean logar(){
    Connection conn = Conexao.connect();
    boolean logado = false;

    try {
      PreparedStatement pstmt = conn.prepareStatement("SELECT email, TRIM(senha) AS senha FROM usuario WHERE email = ?");
      pstmt.setString(1, getEmail());
      ResultSet rs = pstmt.executeQuery();
    
      if (rs.next()) {
        String senhaBD = rs.getString("senha");
        if(senhaBD.equals(getSenha())){
          logado = true;
          conn.close();
        }
      }
    
    } catch (SQLException e) {      
      Conexao.printSQLException(e);
    }
    return logado;
  }

}
