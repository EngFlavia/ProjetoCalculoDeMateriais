package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Projeto;
import dao.interfaces.IProjetosDAO;

public class ProjetoDAO implements IProjetosDAO {

    private Connection conn;

    public ProjetoDAO() {
        conn = ConnectionFactory.getConnection();
    }

   
    
    private void Inserir(Projeto projeto) {
        try {
            String sql = "Insert Into Projeto (IdCliente, IdUsuario, Descricao, ART, Endereco, Cidade) Values (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, projeto.getIdCliente());
            stmt.setInt(2, projeto.getIdUsuario());
            stmt.setString(3, projeto.getDescricao());
            stmt.setString(4, projeto.getART());
            stmt.setString(5, projeto.getEndereco());
            stmt.setString(6, projeto.getCidade());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void Editar(Projeto projeto) {
        try {
            String sql = "Update Projeto set IdCliente = ?, IdUsuario = ?, Descricao = ?, ART = ?, Endereco = ?, Cidade = ? Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, projeto.getIdCliente());
            stmt.setInt(2, projeto.getIdUsuario());
            stmt.setString(3, projeto.getDescricao());
            stmt.setString(4, projeto.getART());
            stmt.setString(5, projeto.getDescricao());
            stmt.setString(6, projeto.getCidade());
            stmt.setInt(7, projeto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Excluir(int Código) {
        String sql;
        PreparedStatement stmt;
        try {          
            sql = "Delete From Projeto Where Id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Código);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public String EhValido(Projeto projeto) {
        if(projeto.getDescricao().equals(""))
            return "Descrição não pode ser nula";
        
        if(projeto.getIdCliente() <= 0)
            return "Cliente não foi selecionado";
                
        return "";
    }
            
    @Override
    public void Salvar(Projeto projeto) {
        
        if(projeto.getId() > 0)
        {
            Editar(projeto);
            return;
        }
        
        Inserir(projeto);
    }

    @Override
    public Projeto SelecionarPorId(int id) {
        Projeto projeto = null;
        try {
            String query = "Select * From Projeto Where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projeto = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projeto;
    }

    @Override
    public ResultSet SelecionarTabela() {
        try {
            String query = "Select p.Id, p.Descricao, c.Nome, p.ART, p.Endereco, p.Cidade"
                     .concat(" From Projeto p Inner Join Cliente c")
                     .concat(" On p.IdCliente = c.Id");
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private ArrayList<Projeto> DadosParaLista(ResultSet dados) {
        ArrayList<Projeto> listaProjeto = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaProjeto.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaProjeto;         
    }
    
    private Projeto DadoParaObjeto(ResultSet dado) { 
        Projeto projeto = null;
        try {
            projeto = new Projeto(
                        dado.getInt("Id"),
                        dado.getInt("IdCliente"),
                        dado.getInt("IdUsuario"),
                        dado.getString("Descricao"),
                        dado.getString("ART"),
                        dado.getString("Endereco"),
                        dado.getString("Cidade")
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return projeto;        
    }

}
