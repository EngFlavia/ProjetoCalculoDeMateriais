package dao.mysql;

import dao.interfaces.IRelatoriosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatoriosDao implements IRelatoriosDAO {

     private Connection conn;

    public RelatoriosDao() {
        conn = ConnectionFactory.getConnection();
    }    
   
    @Override
    public ResultSet SelecionarPorIdObjeto(int idObjeto) {
        try {
            String query = "Select a.Descricao DescricaoAmbiente, o.Descricao DescricaoObjeto, "
                    .concat(" m.Descricao DescricaoMaterial, mc.CustoTotal, mc.CustoMetro2 ")
                    .concat(" From MaterialCalculado mc ")                    
                    .concat(" Inner Join Material m On m.Id = mc.IdMaterial ") 
                    .concat(" Inner Join Objeto o On o.Id = mc.IdObjeto ")
                    .concat(" Inner Join Ambiente a On a.Id = o.IdAmbiente ")
                    .concat(" Where IdObjeto = ? ");
            PreparedStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, idObjeto);
            return stmt.executeQuery();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
      
}
