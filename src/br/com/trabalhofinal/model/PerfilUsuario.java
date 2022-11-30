package br.com.trabalhofinal.model;

public class PerfilUsuario extends Usuario {
  private boolean online;

  public PerfilUsuario(int id, String nome, String email) {
    super(id, nome, email);
  }

  public boolean isOnline() {
    return online;
  }

  public void setOnline(boolean online) {
    this.online = online;
  }

}
