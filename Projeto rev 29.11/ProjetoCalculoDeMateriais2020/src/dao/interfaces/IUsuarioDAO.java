/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Usuario;

/**
 *
 * @author ngarcia
 */
public interface IUsuarioDAO {

    public void inserir(Usuario usuario);

    public void editar(Usuario usuario);

    public void excluir(int id_user);

    public ArrayList<Usuario> selecionar();

    public Usuario selecionarPorCodigo(int id_user);

    public ResultSet selecionarTabela();
    
    public boolean autenticar(String nome_user, String senha_user);
}
