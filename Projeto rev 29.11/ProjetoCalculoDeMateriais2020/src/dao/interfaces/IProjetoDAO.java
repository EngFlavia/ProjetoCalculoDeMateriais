/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Projeto;

/**
 *
 * @author ngarcia
 */
public interface IProjetoDAO {
    public void inserir(Projeto projeto);

    public void editar(Projeto projeto);

    public void excluir(int Código);

    public ArrayList<Projeto> selecionar();

    public Projeto selecionarPorCodigo(int Código);

    public ResultSet selecionarTabela();
}
