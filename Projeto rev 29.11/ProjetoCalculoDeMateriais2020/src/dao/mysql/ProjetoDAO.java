/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IProjetoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Projeto;

/**
 *
 * @author ngarcia
 */
public class ProjetoDAO implements IProjetoDAO {

    private Connection conn;

    public ProjetoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Projeto projeto) {
        try {
            String sql = "insert into cadastroProjeto(id_pcli,id_puser, NomeProjeto, ART, Endereço, Cidade) values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, projeto.getId_cliente());
            stmt.setInt(2, projeto.getId_puser());
            stmt.setString(3, projeto.getNomeProjeto());
            stmt.setString(4, projeto.getART());
            stmt.setString(5, projeto.getEndereço());
            stmt.setString(6, projeto.getCidade());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Projeto projeto) {
        try {
            String sql = "update cadastroProjeto set id_cliente = ?,id_puser = ?, NomeProjeto = ?,ART = ?, Endereço = ?, Cidade = ? where Código = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, projeto.getId_cliente());
            stmt.setInt(2, projeto.getId_puser());
            stmt.setString(3, projeto.getNomeProjeto());
            stmt.setString(4, projeto.getART());
            stmt.setString(5, projeto.getEndereço());
            stmt.setString(6, projeto.getCidade());
            stmt.setInt(7, projeto.getCódigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int Código) {
        String sql;
        PreparedStatement stmt;
        try {

            sql = "delete from amb_proj where id_projeto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Código);
            stmt.execute();
            stmt.close();

            sql = "delete from cadastroProjeto where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Código);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Projeto> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projeto selecionarPorCodigo(int Código) {
        Projeto projeto = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from cadastroProjeto where id = ?");
            stmt.setInt(1, Código);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projeto = new Projeto(
                        rs.getInt("Código"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_puser"),
                        rs.getString("NomeProjeto"),
                        rs.getString("ART"),
                        rs.getString("Endereço"),
                        rs.getString("Cidade"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projeto;
    }

    @Override
    public ResultSet selecionarTabela() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.id, NomeCliente,"
                    + "p.ART, p.Endereço, p.Cidade  from cadastroProjeto p join cliente c "
                    + "on p.id_cliente = c.id;");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
