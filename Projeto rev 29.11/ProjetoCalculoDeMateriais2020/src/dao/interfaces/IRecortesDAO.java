package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Recorte;

public interface IRecortesDAO {

    public void Salvar(ArrayList<Recorte> recortes);
    
    public void Salvar(Recorte recorte);    

    public void Excluir(int id);
    
    public void ExcluirPorIdObjeto (int id);

    public ArrayList<Recorte> SelecionarPorIdObjeto(int id);

    public ResultSet SelecionarTabelaPorIdObjeto(int id);
}
