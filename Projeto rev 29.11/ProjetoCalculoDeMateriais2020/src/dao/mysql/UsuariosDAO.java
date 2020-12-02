package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;
import dao.interfaces.IUsuariosDAO;

public class UsuariosDAO implements IUsuariosDAO {

    private Connection conn;

    public UsuariosDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void Inserir(Usuario usuario) {
        try {
            String query = "Insert Into Usuario(Login, Senha, Email, Telefone) values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Editar(Usuario usuario) {
        try {
            String query = "Update Usuario Set Login = ?, Senha = ?, Email = ?, Telefone = ? Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setInt(5, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Excluir(int id) {
        try {
            String query = "Delete From usuario Where Id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Usuario> Selecionar() {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario");
            listaUsuario = DadosParaLista(rs);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuario;
    }

    @Override
    public Usuario SelecionarPorCodigo(int id) {
        Usuario usuario = null;
        try {
            String query = "Select * From Usuario Where id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public ResultSet SelecionarTabela() {
        try {
            String query = "Select * From Usuario";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean Autenticar(String login, String senha) {      
        try {
            String query = "Select * From Usuario Where Login = ? And Senha = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Usuario ObterPorLogin(String login){
        Usuario usuario = null;
        try {
            String query = "Select * From Usuario Where Login = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {
                usuario = DadoParaObjeto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    private ArrayList<Usuario> DadosParaLista(ResultSet dados) {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        
        try {
            while (dados.next()) {
                listaUsuario.add(DadoParaObjeto(dados));        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listaUsuario;         
    }
    
    private Usuario DadoParaObjeto(ResultSet dado) { 
        Usuario usuario = null;
        try {
            usuario = new Usuario(
                        dado.getInt("Id"),
                        dado.getString("Login"),
                        dado.getString("Senha"),
                        dado.getString("Email"),
                        dado.getString("Telefone")
            );                 
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;        
    }


}
