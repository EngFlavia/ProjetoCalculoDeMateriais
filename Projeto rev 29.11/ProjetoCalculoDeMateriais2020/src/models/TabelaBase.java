package models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TabelaBase {
    private Vector<String> colunas = null;
    private Vector<Vector<Object>> dados = null;
    
    public TabelaBase(ResultSet tbl)
    {
        Processar(tbl);
    }
    
    private void Processar(ResultSet tbl){
        try {
            ResultSetMetaData metaData = tbl.getMetaData();
            int columnCount = metaData.getColumnCount();
                        
            colunas = new Vector<String>();            
            for (int column = 1; column <= columnCount; column++) {
                colunas.add(metaData.getColumnName(column));
            }
            
            dados = new Vector<Vector<Object>>();
            while (tbl.next()) {
                Vector<Object> vectorTbl = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vectorTbl.add(tbl.getObject(columnIndex));
                }
                dados.add(vectorTbl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Vector<String> ObterColuna(){
        return colunas;
    }
    
    public Vector<Vector<Object>> ObterDados() {
        return dados;     
    }   
    
}