/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IObjetoCalculoMaterialMateriaisDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ObjetoCalculoMaterialMateriais;

/**
 *
 * @author ngarcia
 */
public class ObjetoCalculoDAO implements IObjetoCalculoMaterialMateriaisDAO {

     private Connection conn;

    public ObjetoCalculoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(ObjetoCalculoMaterialMateriais objetoCalculoMaterialMateriais) {
try {
            String sql = "insert into objCalcMat_mat(quantidade,id_ocmMat, id_ocmMatCalc, qntDmao_ocm) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, objetoCalculoMaterialMateriais.getQuantidade());
            stmt.setInt(2, objetoCalculoMaterialMateriais.getId_ocmMat());
            stmt.setInt(3, objetoCalculoMaterialMateriais.getId_ocmMatCalc());
            stmt.setInt(4, objetoCalculoMaterialMateriais.getQntDmao_ocm());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void editar(ObjetoCalculoMaterialMateriais objetoCalculoMaterialMateriais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id_ocm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ObjetoCalculoMaterialMateriais> selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjetoCalculoMaterialMateriais selecionarPorCodigo(int id_ocm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selecionarTabela() {
try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.id_ocm, p.quantidade, nome_mat, nome_objCalcMat, p.qntDmao_ocm from objCalcMat_mat p join materiais c on p.id_ocmMat = c.id_mat join objCalcMat b on p.id_ocmMatCalc = b.id_objCalcMat");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     }
    
}
