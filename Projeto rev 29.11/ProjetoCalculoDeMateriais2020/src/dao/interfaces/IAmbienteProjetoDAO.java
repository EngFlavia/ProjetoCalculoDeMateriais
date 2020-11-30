/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.AmbienteProjeto;

/**
 *
 * @author ngarcia
 */
public interface IAmbienteProjetoDAO {

    public void inserir(AmbienteProjeto ambiente);

    public void editar(AmbienteProjeto ambiente);

    public void excluir(int id_ambproj);

    public ArrayList<AmbienteProjeto> selecionar();

    public AmbienteProjeto selecionarPorCodigo(int id_ambproj);

    public ResultSet selecionarTabela();
}
