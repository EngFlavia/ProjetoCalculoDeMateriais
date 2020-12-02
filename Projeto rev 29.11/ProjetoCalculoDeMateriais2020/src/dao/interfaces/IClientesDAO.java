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
public interface IClientesDAO {

    public void Inserir(Cliente cliente);

    public void Editar(Cliente cliente);

    public void Excluir(int id);

    public ArrayList<Cliente> Selecionar();

    public Cliente SelecionarPorId(int id);

    public ResultSet SelecionarTabela();

}
