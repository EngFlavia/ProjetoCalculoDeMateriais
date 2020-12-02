package dao.mysql;

import dao.interfaces.IMateriaisDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Material;
import models.Projeto;

public class MateriaisDAO implements IMateriaisDAO {

    private Connection conn;

    public MateriaisDAO() {
        conn = ConnectionFactory.getConnection();
    }
           
    public void Inserir(Material material) {
        try {
            String sql = "Insert Into Material (Descricao, Altura, Largura, QuantidadeLote, "
                    .concat(" Rendimento, Custo, Quebra, IdMaterialTipo)")
                    .concat(" Values (?,?,?,?,?,?,?,?,?) ");
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, material.getDescricao());
            stmt.setFloat(2, material.getAltura());
            stmt.setFloat(3, material.getLargura());
            stmt.setFloat(4, material.getQuantidadeLote());
            stmt.setFloat(5, material.getRendimento());
            stmt.setFloat(6, material.getCusto());
            stmt.setFloat(7, material.getQuebra());
            stmt.setFloat(8, material.getIdMaterialTipo());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Editar(Material material) {
         try {
            String sql = "Update Material Set Descricao = ?, Altura = ?, Largura = ?, QuantidadeLote = ?, "
                    .concat(" Rendimento = ?, Custo = ?, Quebra = ? ")
                    .concat(" Where Id = ? ");
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, material.getDescricao());
            stmt.setFloat(2, material.getAltura());
            stmt.setFloat(3, material.getLargura());
            stmt.setFloat(4, material.getQuantidadeLote());
            stmt.setFloat(5, material.getRendimento());
            stmt.setFloat(6, material.getCusto());
            stmt.setFloat(7, material.getQuebra());
            stmt.setFloat(8, material.getId());            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Salvar(ArrayList<Material> materiais) {
        for(Material material : materiais)
        {
            Salvar(material);
        }
    }
    
    @Override
    public void Salvar(Material material) {        
        if(material.getId() > 0){
            Editar(material);           
        }
        else
        {
            Inserir(material);
        }                      
    }
    
    @Override
    public void Excluir(int id) {
        try {                                    
            String sql = "Delete From Material Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @Override
    public ArrayList<Material> Selecionar() {
        ArrayList<Material> listaMateriais = null;
        try {
            String query = "Select * From Material";
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(query);
            
            listaMateriais = DadosParaLista(rs);
            
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaMateriais;
    }
    
    @Override
    public Material SelecionarPorId(int id) {
        Material material = null;
        try {
            String query = "Select * From Material Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                material = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return material;
    }
    
    private ArrayList<Material> DadosParaLista(ResultSet dados) {
        ArrayList<Material> listaMaterial = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaMaterial.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaMaterial;         
    }
    
    private Material DadoParaObjeto(ResultSet dado) { 
        Material material = null;
        try {
            material = new Material(
                        dado.getInt("Id"),
                        dado.getInt("IdMaterialTipo"),                        
                        dado.getString("Descricao"),
                        dado.getFloat("Altura"),
                        dado.getFloat("Largura"),
                        dado.getFloat("QuantidadeLote"),
                        dado.getFloat("Rendimento"),
                        dado.getFloat("Custo"),
                        dado.getFloat("Quebra")
                        
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return material;        
    }

}
