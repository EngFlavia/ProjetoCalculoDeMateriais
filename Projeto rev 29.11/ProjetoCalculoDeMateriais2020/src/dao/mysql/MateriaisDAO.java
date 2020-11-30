/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.interfaces.IMateriaisDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Materiais;

/**
 *
 * @author ngarcia
 */
public class MateriaisDAO implements IMateriaisDAO {

    private Connection conn;

    public MateriaisDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Materiais materiais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Materiais materiais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id_mat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Materiais> selecionar() {
        ArrayList<Materiais> listaMaterial = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from materiais");
            while (rs.next()) {
                listaMaterial.add(
                        new Materiais(
                                rs.getInt("id_mat"),
                                rs.getString("nome_mat"),
                                rs.getInt("id_mcateg"),
                                rs.getFloat("qntVenda_mat"),
                                rs.getFloat("qntRendimento_mat"),
                                rs.getFloat("Custo_mat"),
                                rs.getFloat("Quebra_mat")));
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaterial;
    }

    @Override
    public Materiais selecionarPorCodigo(int id_mat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet selecionarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
