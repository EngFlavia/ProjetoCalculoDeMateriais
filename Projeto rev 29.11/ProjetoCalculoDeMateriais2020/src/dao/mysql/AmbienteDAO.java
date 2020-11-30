/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IAmbienteProjetoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AmbienteProjeto;

/**
 *
 * @author ngarcia
 */
public class AmbienteDAO implements IAmbienteProjetoDAO {

    private Connection conn;

    public AmbienteDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(AmbienteProjeto ambiente) {
        try {
            String sql = "insert into cadastroAmbiente(nome, id_projeto) values (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ambiente.getNome());
            stmt.setInt(2, ambiente.getId_projeto());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(AmbienteProjeto ambiente) {

        try {
            String sql = "update cadastroAmbiente set nome = ? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, ambiente.getNome());
            stmt.setInt(2, ambiente.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AmbienteProjeto> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AmbienteProjeto selecionarPorCodigo(int id) {
        AmbienteProjeto ambiente = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from cadastroAmbiente where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ambiente = new AmbienteProjeto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("id_projeto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ambiente;
    }

    public ResultSet rsPorCodigo(int id) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from cadastroAmbiente where id_projeto = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public ResultSet selecionarTabela() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nome from cadastroAmbiente");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
