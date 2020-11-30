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
public interface IObjetoDAO {

    public void inserir(ObjetoCalculoMaterial objeto);

    public void editar(ObjetoCalculoMaterial objeto);

    public void excluir(int id_user);

    public ArrayList<ObjetoCalculoMaterial> selecionar();

    public ObjetoCalculoMaterial selecionarPorCodigo(int id_user);

    public ResultSet selecionarTabela();    

}
