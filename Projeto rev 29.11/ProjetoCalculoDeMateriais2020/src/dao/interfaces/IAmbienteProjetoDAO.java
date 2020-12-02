package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Ambiente;

public interface IAmbienteProjetoDAO {

    public void Salvar(Ambiente ambiente);

    public void Excluir(int id);

    public ArrayList<Ambiente> Selecionar();

    public Ambiente SelecionarPorId(int id);

    public ResultSet SelecionarTabelaPorIdProjeto(int idProjeto);
}
