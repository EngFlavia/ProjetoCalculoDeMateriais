/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.ObjetoCalculoMaterialRecorte;

/**
 *
 * @author ngarcia
 */
public interface IObjetoCalculoMaterialRecorteDAO {

    public void inserir(ObjetoCalculoMaterialRecorte objetoCalculoMaterial);

    public void editar(ObjetoCalculoMaterialRecorte objetoCalculoMaterial);

    public void excluir(int id_objCalcMat);

    public ArrayList<ObjetoCalculoMaterialRecorte> selecionar();

    public ArrayList<ObjetoCalculoMaterialRecorte> selecionarPorIdCalculo(int idCalculo);

    public ResultSet selecionarTabela();
}
