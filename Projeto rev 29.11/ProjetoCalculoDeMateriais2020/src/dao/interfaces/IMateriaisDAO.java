/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Materiais;

/**
 *
 * @author ngarcia
 */
public interface IMateriaisDAO {

    public void inserir(Materiais materiais);

    public void editar(Materiais materiais);

    public void excluir(int id_mat);

    public ArrayList<Materiais> selecionar();

    public Materiais selecionarPorCodigo(int id_mat);

    public ResultSet selecionarTabela();
}
