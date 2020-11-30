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
public class Usuario {
    private int id_user;
    private String nome_user;
    private String senha_user;
    private String email_user;
    private String tel_user;
    
    public Usuario(){}
    public Usuario(int id_user, String nome_user, String senha_user, String email_user,String tel_user ){
    this.id_user = id_user;
    this.nome_user = nome_user;
    this.senha_user = senha_user;
    this.email_user = email_user;
    this.tel_user = tel_user;    
    
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the nome_user
     */
    public String getNome_user() {
        return nome_user;
    }

    /**
     * @param nome_user the nome_user to set
     */
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    /**
     * @return the senha_user
     */
    public String getSenha_user() {
        return senha_user;
    }

    /**
     * @param senha_user the senha_user to set
     */
    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }

    /**
     * @return the email_user
     */
    public String getEmail_user() {
        return email_user;
    }

    /**
     * @param email_user the email_user to set
     */
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    /**
     * @return the tel_user
     */
    public String getTel_user() {
        return tel_user;
    }

    /**
     * @param tel_user the tel_user to set
     */
    public void setTel_user(String tel_user) {
        this.tel_user = tel_user;
    }
    
}
