/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.ObjetoCalculoMaterial;

/**
 *
 * @author ngarcia
 */
public interface IObjetoCalculoMaterialDAO {

    public void inserir(ObjetoCalculoMaterial objetoCalculoMaterial);

    public void editar(ObjetoCalculoMaterial objetoCalculoMaterial);

    public void excluir(int id_objCalcMat);

    public ArrayList<ObjetoCalculoMaterial> selecionar();

    public ObjetoCalculoMaterial selecionarPorCodigo(int id_objCalcMat);

    public ResultSet selecionarTabela(int codigo);
}
