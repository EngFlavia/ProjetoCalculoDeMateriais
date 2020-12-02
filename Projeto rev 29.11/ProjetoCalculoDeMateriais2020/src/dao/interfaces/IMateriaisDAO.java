package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Material;

public interface IMateriaisDAO {

    public Material SelecionarPorId(int id);
    
    public void Salvar(ArrayList<Material> materiais);

    public void Salvar(Material material);

    public void Excluir(int id);
       
    public ArrayList<Material> Selecionar();
   
    
}
