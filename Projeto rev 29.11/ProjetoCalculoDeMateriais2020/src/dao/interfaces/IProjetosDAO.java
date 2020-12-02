package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Projeto;

public interface IProjetosDAO {      
    public String EhValido(Projeto projeto);
            
    public void Salvar(Projeto projeto);

    public void Excluir(int id);

    public Projeto SelecionarPorId(int id);

    public ResultSet SelecionarTabela();
}
