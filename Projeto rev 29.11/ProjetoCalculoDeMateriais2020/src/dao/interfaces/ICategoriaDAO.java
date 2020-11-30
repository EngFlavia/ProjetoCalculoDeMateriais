/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Categoria;

/**
 *
 * @author ngarcia
 */
public interface ICategoriaDAO {
     public void inserir(Categoria categoria);
    public void editar(Categoria categoria);
    public void excluir(int id_categ);
    public ArrayList<Categoria> selecionar();
    public Categoria selecionarPorCodigo(int id_categ);
    public ResultSet selecionarTabela();
}
