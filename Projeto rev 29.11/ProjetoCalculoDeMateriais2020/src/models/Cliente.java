/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ngarcia
 */
public class Cliente {

    private int id_cli;
    private String NomeCliente;
    private String email_cli;
    private String tel_cli;

    public Cliente() {
    }

    public Cliente(int id_cli, String NomeCliente, String email_cli, String tel_cli) {
        this.id_cli = id_cli;
        this.NomeCliente = NomeCliente;
        this.email_cli = email_cli;
        this.tel_cli = tel_cli;

    }

    @Override
    public String toString() {
        return id_cli + " - " + NomeCliente;
    }

    /**
     * @return the id_cli
     */
    public int getId_cli() {
        return id_cli;
    }

    /**
     * @param id_cli the id_cli to set
     */
    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    /**
     * @return the NomeCliente
     */
    public String getNomeCliente() {
        return NomeCliente;
    }

    /**
     * @param NomeCliente the NomeCliente to set
     */
    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    /**
     * @return the email_cli
     */
    public String getEmail_cli() {
        return email_cli;
    }

    /**
     * @param email_cli the email_cli to set
     */
    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    /**
     * @return the tel_cli
     */
    public String getTel_cli() {
        return tel_cli;
    }

    /**
     * @param tel_cli the tel_cli to set
     */
    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

}
