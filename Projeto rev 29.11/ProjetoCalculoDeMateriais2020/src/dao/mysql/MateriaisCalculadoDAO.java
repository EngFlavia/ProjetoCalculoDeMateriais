package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.MaterialCalculado;
import dao.interfaces.IMateriaisCalculadoDAO;

public class MateriaisCalculadoDAO implements IMateriaisCalculadoDAO {

     private Connection conn;

    public MateriaisCalculadoDAO() {
        conn = ConnectionFactory.getConnection();
    }    
    
    public void Inserir(MaterialCalculado materialCalculado) {
        try {
            String sql = "Insert Into MaterialCalculado (Quantidade, QuantidadeDeMao, CustoTotal, CustoMetro2, IdMaterial, IdObjeto) Values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, materialCalculado.getQuantidade());
            stmt.setInt(2, materialCalculado.getQuantidadeDeMao());
            stmt.setFloat(3, materialCalculado.getCustoTotal());
            stmt.setFloat(4, materialCalculado.getCustoMetro2());
            stmt.setInt(5, materialCalculado.getIdMaterial());
            stmt.setInt(6, materialCalculado.getIdObjeto());
            stmt.execute(); 
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public void Editar(MaterialCalculado materialCalculado) {
        try {
            String sql = "Update MaterialCalculado Set Quantidade = ?, QuantidadeDeMao = ?, CustoTotal = ?, CustoMetro2 = ? "
                    .concat(" Where Id = ?");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, materialCalculado.getQuantidade());
            stmt.setInt(2, materialCalculado.getQuantidadeDeMao());
            stmt.setFloat(3, materialCalculado.getCustoTotal());
            stmt.setFloat(4, materialCalculado.getCustoMetro2());
            stmt.setInt(5, materialCalculado.getId());
            stmt.execute(); 
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public void Salvar(ArrayList<MaterialCalculado> materiaisCalculo) {
        for(MaterialCalculado materialCalculo : materiaisCalculo)
        {
            Salvar(materialCalculo);
        }
    }
    
    @Override
    public void Salvar(MaterialCalculado materialCalculo) {        
        if(materialCalculo.getId() > 0){
            Editar(materialCalculo);           
        }
        else
        {
            Inserir(materialCalculo);
        }                      
    }
    
    @Override
    public void Excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ExcluirPorIdObjeto(int idObjeto) {
        try {                                    
            String sql = "Delete From MaterialCalculado Where IdObjeto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObjeto);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<MaterialCalculado> SelecionarPorIdObjeto(int idObjeto) {
        ArrayList<MaterialCalculado> listaMateriaisCalculo = new ArrayList<>();
        try {
            String query = "Select * From MaterialCalculado Where IdObjeto = ?";
            PreparedStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, idObjeto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listaMateriaisCalculo = DadosParaLista(rs);
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaMateriaisCalculo;
    }


    @Override
    public ResultSet SelecionarTabelaPorIdObjeto(int idObjeto) {
        try {
            String query = "Select mc.Id, mc.Quantidade, m.Descricao, o.Descricao, mc.QuantidadeDeMao, mc.CustoTotal, mc.CustoMetro2 "
                    .concat(" From MaterialCalculado mc ")
                    .concat(" Inner Join Material m On m.Id = mc.IdMaterial ") 
                    .concat(" Inner Join Objeto o On o.Id = mc.IdObjeto ")
                    .concat(" Where IdObjeto = ? ");
            PreparedStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, idObjeto);
            return stmt.executeQuery();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
    
    private ArrayList<MaterialCalculado> DadosParaLista(ResultSet dados) {
        ArrayList<MaterialCalculado> listaMateriaisCalculo = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaMateriaisCalculo.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaMateriaisCalculo;         
    }
    
    private MaterialCalculado DadoParaObjeto(ResultSet dado) { 
        MaterialCalculado materialCalculo = null;
        try {
            materialCalculo = new MaterialCalculado(
                        dado.getInt("Id"),
                        dado.getInt("Quantidade"),
                        dado.getInt("QuantidadeDeMao"),
                        dado.getFloat("CustoTotal"),
                        dado.getFloat("CustoMetro2"),
                        dado.getInt("IdMaterial"),
                        dado.getInt("IdObjeto")                     
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return materialCalculo;        
    }
}
