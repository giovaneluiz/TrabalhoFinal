package br.com.trabalhofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private final static String url = "jdbc:postgresql://motty.db.elephantsql.com/hxqgcvjm";
  private final static String user = "hxqgcvjm";
  private final static String password = "b1VhF6tIkTEPWc4nH0S584qE-dKK1dev";
  private static Connection conn = null;

  public static Connection connect() {
    try {
      conn = DriverManager.getConnection(url, user, password);
      if (conn != null) {
        System.out.println("Banco de dados conectado com sucesso!");
      } else {
        System.out.println("Falha na conexão com o banco de dados!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public static void printSQLException(SQLException ex) {
    for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}
}
