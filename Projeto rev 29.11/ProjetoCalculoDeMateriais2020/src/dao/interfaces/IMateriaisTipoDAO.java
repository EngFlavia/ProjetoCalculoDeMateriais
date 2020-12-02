package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.MaterialTipo;

public interface IMateriaisTipoDAO {
    public void Inserir(MaterialTipo materialTipo);
    
    public void Editar(MaterialTipo materialTipo);
    
    public void Excluir(int id);
    
    public ArrayList<MaterialTipo> Selecionar();
    
    public MaterialTipo selecionarPorCodigo(int id);
    
    public ResultSet selecionarTabela();
}
