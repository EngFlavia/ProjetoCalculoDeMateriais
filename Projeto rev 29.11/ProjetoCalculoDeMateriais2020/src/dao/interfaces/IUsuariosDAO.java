package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Usuario;

public interface IUsuariosDAO {

    public void Inserir(Usuario usuario);

    public void Editar(Usuario usuario);

    public void Excluir(int id);

    public ArrayList<Usuario> Selecionar();

    public Usuario SelecionarPorCodigo(int id);

    public ResultSet SelecionarTabela();
    
    public boolean Autenticar(String login, String senha);
    
    public Usuario ObterPorLogin(String login);
}
