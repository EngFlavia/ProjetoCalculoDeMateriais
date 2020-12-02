package dao.mysql;

import dao.interfaces.IObjetosDAO;
import dao.interfaces.IRecortesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Objeto;
import dao.interfaces.IMateriaisCalculadoDAO;

public class ObjetoDAO implements IObjetosDAO {               
    private Connection conn = null;
    private IRecortesDAO recortesDao = null;
    private IMateriaisCalculadoDAO materiaisCalculoDao = null;

    public ObjetoDAO() {
        conn = ConnectionFactory.getConnection();
        recortesDao = new RecortesDAO();
        materiaisCalculoDao = new MateriaisCalculadoDAO();
    }
    
    @Override
    public void Salvar(Objeto objeto) {
        if(objeto.getId() > 0){
            Editar(objeto);           
        }
        else
        {
            Inserir(objeto);
        }                   
    }
        
    @Override
    public void Excluir(int id) {                 
        try {            
            recortesDao.ExcluirPorIdObjeto(id);
            materiaisCalculoDao.ExcluirPorIdObjeto(id);
            
            String sql = "Delete From Objeto Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Objeto SelecionarPorId(int id) {
        Objeto objeto = null;
        try {
            String query = "Select * From Objeto Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                objeto = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objeto;
    }

    @Override
    public ResultSet SelecionarTabelaPorIdAmbiente(int id) {
        ResultSet rs;
        try {
            String sql = "SELECT Id, Descricao, Altura, Largura From Objeto where IdAmbiente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   

    public void Inserir(Objeto objeto) {
        try {
            String sql = "Insert Into Objeto (Descricao, Altura, Largura, IdAmbiente) Values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, objeto.getDescricao());
            stmt.setFloat(2, objeto.getAltura());
            stmt.setFloat(3, objeto.getLargura());            
            stmt.setInt(4, objeto.getIdAmbiente());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next())
            {
                objeto.setId(rs.getInt(1));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Editar(Objeto objeto) {
        try {
            String sql = "Update Objeto Set Descricao = ?, Altura = ?, Largura = ? Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, objeto.getDescricao());
            stmt.setFloat(2, objeto.getAltura());
            stmt.setFloat(3, objeto.getLargura());                        
            stmt.setInt(4, objeto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private ArrayList<Objeto> DadosParaLista(ResultSet dados) {
        ArrayList<Objeto> listaObjeto = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaObjeto.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaObjeto;         
    }
    
    private Objeto DadoParaObjeto(ResultSet dado) { 
        Objeto objeto = null;
        try {
            objeto = new Objeto(
                        dado.getInt("Id"),                   
                        dado.getString("Descricao"),
                        dado.getInt("Altura"),
                        dado.getInt("Largura"),
                        dado.getInt("IdAmbiente")
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return objeto;        
    }
}
