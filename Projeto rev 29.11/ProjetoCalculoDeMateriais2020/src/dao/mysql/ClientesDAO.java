package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;
import dao.interfaces.IClientesDAO;

public class ClientesDAO implements IClientesDAO {

    private Connection conn;

    public ClientesDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void Inserir(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Editar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> Selecionar() {
        ArrayList<Cliente> listaCliente = null;
        
        try {
            String query = "Select * From Cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            listaCliente = DadosParaLista(rs);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCliente;
    }

    @Override
    public Cliente SelecionarPorId(int id) {
        Cliente cliente=null;
        try {
            String query = "Select * From Cliente Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = DadoParaObjeto(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }

    @Override
    public ResultSet SelecionarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private ArrayList<Cliente> DadosParaLista(ResultSet dados) {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        
        try {
          while (dados.next()) {
            listaCliente.add(DadoParaObjeto(dados));        
          }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaCliente;         
    }
    
    private Cliente DadoParaObjeto(ResultSet dado) { 
        Cliente cliente = null;
        try {
            cliente = new Cliente(
                dado.getInt("Id"),
                dado.getString("Nome"),
                dado.getString("Email"),
                dado.getString("Telefone")
            );        
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;        
    }
    
}
