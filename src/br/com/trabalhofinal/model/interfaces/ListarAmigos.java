package br.com.trabalhofinal.model.interfaces;

import br.com.trabalhofinal.model.PerfilUsuario;
import java.util.ArrayList;

public interface ListarAmigos {
  ArrayList<PerfilUsuario> busca(int id_usuario_logado);
}
