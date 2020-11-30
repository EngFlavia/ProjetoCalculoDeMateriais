/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IObjetoCalculoMaterialRecorteDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ObjetoCalculoMaterialRecorte;

/**
 *
 * @author ngarcia
 */
public class ObjetoRecorteDAO implements IObjetoCalculoMaterialRecorteDAO {

    private Connection conn;

    public ObjetoRecorteDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(ObjetoCalculoMaterialRecorte objetoCalculoMaterial) {
        try {
            String sql = "insert into cadastroRecorte(nome,altura, largura, area, id_Objeto) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, objetoCalculoMaterial.getNome());
            stmt.setFloat(2, objetoCalculoMaterial.getAltura());
            stmt.setFloat(3, objetoCalculoMaterial.getLargura());
            stmt.setFloat(4, objetoCalculoMaterial.CalcularArea());
            stmt.setInt(5, objetoCalculoMaterial.getId_Objeto());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void editar(ObjetoCalculoMaterialRecorte objetoCalculoMaterial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id_objCalcMat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ObjetoCalculoMaterialRecorte> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ObjetoCalculoMaterialRecorte> selecionarPorIdCalculo(int idCalculo) {
        
        try {
                String query = "SELECT id, nome, altura, largura, id_Objeto from cadastroRecorte Where id_Objeto = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, idCalculo);
                ResultSet rs = stmt.executeQuery();                             
                return ConvertDataToList(rs);
                
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }

    @Override
    public ResultSet selecionarTabela() {
        try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, nome, altura, largura, id_Objeto from cadastroRecorte");
                return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }

    private ArrayList<ObjetoCalculoMaterialRecorte> ConvertDataToList(ResultSet rs) {
        ArrayList<ObjetoCalculoMaterialRecorte> listaRecortes = new ArrayList<ObjetoCalculoMaterialRecorte>();
         try {
            while (rs.next()) {
                ObjetoCalculoMaterialRecorte recort = new ObjetoCalculoMaterialRecorte(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("altura"),
                rs.getInt("largura"),
                rs.getInt("id_Objeto"));                        
                listaRecortes.add(recort);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaRecortes;                 
    }
    
}
