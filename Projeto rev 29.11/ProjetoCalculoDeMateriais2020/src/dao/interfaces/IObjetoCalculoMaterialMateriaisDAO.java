/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.ObjetoCalculoMaterialMateriais;

/**
 *
 * @author ngarcia
 */
public interface IObjetoCalculoMaterialMateriaisDAO {

    public void inserir(ObjetoCalculoMaterialMateriais objetoCalculoMaterialMateriais);

    public void editar(ObjetoCalculoMaterialMateriais objetoCalculoMaterialMateriais);

    public void excluir(int id_ocm);

    public ArrayList<ObjetoCalculoMaterialMateriais> selecionar();

    public ObjetoCalculoMaterialMateriais selecionarPorCodigo(int id_ocm);

    public ResultSet selecionarTabela();
}
