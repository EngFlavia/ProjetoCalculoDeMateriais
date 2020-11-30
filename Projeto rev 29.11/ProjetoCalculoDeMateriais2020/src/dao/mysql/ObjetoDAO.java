/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IObjetoCalculoMaterialDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ObjetoCalculoMaterial;

/**
 *
 * @author Flavia
 */
public class ObjetoDAO implements IObjetoCalculoMaterialDAO {

    private Connection conn;

    public ObjetoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(ObjetoCalculoMaterial objeto) {
        try {
            String sql = "insert into cadastroObjeto(nome,altura, largura, area, id_ambiente) values (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, objeto.getNome_objCalcMat());
            stmt.setFloat(2, objeto.getAltura());
            stmt.setFloat(3, objeto.getLargura());
            stmt.setFloat(4, 0);
            stmt.setInt(5, objeto.getId_ambiente());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(ObjetoCalculoMaterial objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        String sql;
        PreparedStatement stmt;
        try {
            sql = "delete from objcalcmatrecorte where id_Objeto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

            sql = "delete from cadastroObjeto where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ObjetoCalculoMaterial> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoCalculoMaterial selecionarPorCodigo(int id_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selecionarTabela(int codigo) {
        ResultSet rs;
        try {
            String sql = "SELECT id, nome, altura, largura from cadastroObjeto where cadastroObjeto.id_ambiente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//     public ArrayList<ObjetoCalculoMaterial>AreaFinal(int id_objCalcMat) {
//         ResultSet rs;
//        try {
//           
//            String sql = "SELECT area_rec from objCalcMatRecorte where id_Calculo = ?";
//            
//            for (int i = 0; i < sql.length(); i++) {
//                
//                float areRecorteTotal += sql.area_rec ;                
//            }
//            
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            
//            
//            //stmt.setInt(1, codigo);
//            //rs = stmt.executeQuery();
//            //return rs;
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//         
//    }

}
