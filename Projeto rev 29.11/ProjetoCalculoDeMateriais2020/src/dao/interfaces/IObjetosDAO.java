package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Objeto;

public interface IObjetosDAO {
    public void Salvar(Objeto objeto);  

    public void Excluir(int id);

    public Objeto SelecionarPorId(int id);

    public ResultSet SelecionarTabelaPorIdAmbiente(int id);    

}
