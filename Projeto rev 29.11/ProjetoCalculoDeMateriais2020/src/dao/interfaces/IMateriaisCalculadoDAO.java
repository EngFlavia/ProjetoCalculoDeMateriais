package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.MaterialCalculado;

public interface IMateriaisCalculadoDAO {

    public void Salvar(ArrayList<MaterialCalculado> materiaisCalculo);
    
    public void Salvar(MaterialCalculado materialCalculo);
         
    public void ExcluirPorIdObjeto(int idbjeto);

    public void Excluir(int id);

    public ArrayList<MaterialCalculado> SelecionarPorIdObjeto(int idObjeto);    

    public ResultSet SelecionarTabelaPorIdObjeto(int id);
}
