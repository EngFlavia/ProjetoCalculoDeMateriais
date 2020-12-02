package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Recorte;
import dao.interfaces.IRecortesDAO;

public class RecortesDAO implements IRecortesDAO {

    private Connection conn;

    public RecortesDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void Salvar(ArrayList<Recorte> recortes) {
        for(Recorte recorte : recortes)
        {
            Salvar(recorte);
        }
    }
    
    @Override
    public void Salvar(Recorte recorte) {        
        if(recorte.getId() > 0){
            Editar(recorte);           
        }
        else
        {
            Inserir(recorte);
        }                      
    }
        
    public void Inserir(Recorte recorte) {
        try {
            String sql = "Insert Into Recorte (Descricao, Altura, Largura, IdObjeto) Values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, recorte.getDescricao());
            stmt.setFloat(2, recorte.getAltura());
            stmt.setFloat(3, recorte.getLargura());            
            stmt.setInt(4, recorte.getIdObjeto());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void Editar(Recorte recorte) {
        try {
            String sql = "Update Recorte Set Descricao = ?, Altura = ?, Largura = ?) Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, recorte.getDescricao());
            stmt.setFloat(2, recorte.getAltura());
            stmt.setFloat(3, recorte.getLargura());            
            stmt.setInt(4, recorte.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void Excluir(int id) {        
        try {                                    
            String sql = "Delete From Recorte Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void ExcluirPorIdObjeto(int idObjeto) {
        String sql;
        PreparedStatement stmt;
        try {                                    
            sql = "Delete From Recorte Where IdObjeto = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObjeto);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Recorte> SelecionarPorIdObjeto(int id) {
        
        try {
                String query = "Select Id, Descricao, Altura, Largura, IdObjeto From Recorte Where IdObjeto = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();                             
                return DadosParaLista(rs);
                
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;         
    }

    @Override
    public ResultSet SelecionarTabelaPorIdObjeto(int id) {
        try {
                String query = "Select Id, Descricao, Altura, Largura From Recorte Where IdObjeto = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);
                return stmt.executeQuery();                                 
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }

    private ArrayList<Recorte> DadosParaLista(ResultSet dados) {
        ArrayList<Recorte> listaMaterial = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaMaterial.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaMaterial;         
    }
    
    private Recorte DadoParaObjeto(ResultSet dado) { 
        Recorte recorte = null;
        try {
            recorte = new Recorte(
                dado.getInt("Id"),
                dado.getString("Descricao"),
                dado.getInt("Altura"),
                dado.getInt("Largura"),
                dado.getInt("idObjeto")
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return recorte;        
    }
    
}
