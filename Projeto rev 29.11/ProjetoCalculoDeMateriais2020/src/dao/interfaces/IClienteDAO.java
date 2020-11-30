/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author ngarcia
 */
public interface IClienteDAO {

    public void inserir(Cliente cliente);

    public void editar(Cliente cliente);

    public void excluir(int id_cli);

    public ArrayList<Cliente> selecionar();

    public Cliente selecionarPorCodigo(int id_cli);

    public ResultSet selecionarTabela();

}
