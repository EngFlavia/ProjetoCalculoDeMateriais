/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

/**
 *
 * @author ngarcia
 */
public class UsuarioDAO implements IUsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Usuario usuario) {
        try {
            String sql = "insert into usuario(nome_user,senha_user, email_user, tel_user) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome_user());
            stmt.setString(2, usuario.getSenha_user());
            stmt.setString(3, usuario.getEmail_user());
            stmt.setString(4, usuario.getTel_user());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        aplicar ao botao salvar na ;
//        Usuario usu = new Usuario();
//        usu.setLogin(txtUsuario.getText());
//        usu.setSenha(txtSenha.getText());
//        UsuarioDAO uDAO = new UsuarioDAO();
//        uDAO.inserir(usu);
//        JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
    }

    @Override
    public void editar(Usuario usuario) {
        try {
            String sql = "update usuario set nome_user = ?, senha_user = ?, email_user = ?, tel_user = ? where id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome_user());
            stmt.setString(2, usuario.getSenha_user());
            stmt.setString(3, usuario.getEmail_user());
            stmt.setString(4, usuario.getTel_user());
            stmt.setInt(5, usuario.getId_user());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id_user) {
        try {
            String sql = "delete from usuario where id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_user);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Usuario> selecionar() {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario");
            while (rs.next()) {
                listaUsuario.add(new Usuario(
                        rs.getInt("id_user"),
                        rs.getString("nome_user"),
                        rs.getString("senha_user"),
                        rs.getString("email_user"),
                        rs.getString("tel_user")));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario;
    }

    @Override
    public Usuario selecionarPorCodigo(int id_user) {
        Usuario usuario = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where id_user = ?");
            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_user"),
                        rs.getString("nome_user"),
                        rs.getString("senha_user"),
                        rs.getString("email_user"),
                        rs.getString("tel_user"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public ResultSet selecionarTabela() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean autenticar(String nome_user, String senha_user) {
         Usuario usuario = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where nome_user = ? and senha_user = ?");
            stmt.setString(1, nome_user);
            stmt.setString(2, senha_user);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
