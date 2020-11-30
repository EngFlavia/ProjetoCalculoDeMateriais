/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Cliente;

/**
 *
 * @author ngarcia
 */
public class ClienteDAO implements IClienteDAO {

    private Connection conn;

    public ClienteDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id_cli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> selecionar() {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente");
            while (rs.next()) {
                listaCliente.add(
                        new Cliente(
                                rs.getInt("id_cli"),
                                rs.getString("NomeCliente"),
                                rs.getString("email_cli"),
                                rs.getString("tel_cli")));
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCliente;
    }

    @Override
    public Cliente selecionarPorCodigo(int id_cli) {
        Cliente cliente=null;
        try {
            String sql = "select * from cliente where cliente.id_cli = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_cli);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(rs.getInt("id_cli"),
                        rs.getString("NomeCliente"),
                        rs.getString("email_cli"),
                        rs.getString("tel_cli"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    @Override
    public ResultSet selecionarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
