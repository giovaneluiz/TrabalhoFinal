package br.com.trabalhofinal.model.interfaces;

import br.com.trabalhofinal.model.PerfilUsuario;
import java.util.ArrayList;

public interface AdicionarAmigo {
  void adicionar(int id_usuario_principal, int id_usuario_amigo);

  ArrayList<PerfilUsuario> buscaUsuarioParaAdicionar(int id_usuario_logado);
}
