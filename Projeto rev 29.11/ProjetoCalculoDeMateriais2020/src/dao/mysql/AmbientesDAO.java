package dao.mysql;

import dao.interfaces.IAmbienteProjetoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Ambiente;

public class AmbientesDAO implements IAmbienteProjetoDAO {

    private Connection conn;

    public AmbientesDAO() {
        conn = ConnectionFactory.getConnection();
    }
    
    public void Inserir(Ambiente ambiente) {
        try {
            String query = "Insert into Ambiente (Descricao, IdProjeto) Values (?,?)";
            PreparedStatement stmt = this.conn.prepareStatement(query);
            stmt.setString(1, ambiente.getDescricao());
            stmt.setInt(2, ambiente.getIdProjeto());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Editar(Ambiente ambiente) {

        try {
            String query = "Update Ambiente Set Descricao = ? Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, ambiente.getDescricao());
            stmt.setInt(2, ambiente.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Salvar(Ambiente ambiente) {        
        if(ambiente.getId() > 0){
            Editar(ambiente);           
        }
        else
        {
            Inserir(ambiente);
        }                      
    }

    @Override
    public void Excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ambiente> Selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ambiente SelecionarPorId(int id) {
        Ambiente ambiente = null;
        try {
            String query = "Select Id, Descricao, IdProjeto From Ambiente Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ambiente = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ambiente;
    }    

    @Override
    public ResultSet SelecionarTabelaPorIdProjeto(int idProjeto) {
        try {
            String query = "Select Id, Descricao From Ambiente Where IdProjeto = ?";
            PreparedStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, idProjeto);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private ArrayList<Ambiente> DadosParaLista(ResultSet dados) {
        ArrayList<Ambiente> listaAmbiente = new ArrayList<>();
        
        try {
          while (dados.next()) {
            listaAmbiente.add(DadoParaObjeto(dados));        
          }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaAmbiente;         
    }
    
    private Ambiente DadoParaObjeto(ResultSet dado) { 
        Ambiente ambiente = null;
        try {
            ambiente = new Ambiente(
                        dado.getInt("Id"),
                        dado.getString("Descricao"),
                        dado.getInt("IdProjeto")
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ambiente;        
    }
}
