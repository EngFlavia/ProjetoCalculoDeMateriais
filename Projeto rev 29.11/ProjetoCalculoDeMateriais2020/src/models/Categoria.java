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
public class Categoria {

    private int id_categ;
    private String nome_categ;

    public Categoria() {
    }

    public Categoria(int id_categ, String nome_categ) {
        this.id_categ = id_categ;
        this.nome_categ = nome_categ;

    }
    /**
     * @return the id_categ
     */
    public int getId_categ() {
        return id_categ;
    }

    /**
     * @param id_categ the id_categ to set
     */
    public void setId_categ(int id_categ) {
        this.id_categ = id_categ;
    }

    /**
     * @return the nome_categ
     */
    public String getNome_categ() {
        return nome_categ;
    }

    /**
     * @param nome_categ the nome_categ to set
     */
    public void setNome_categ(String nome_categ) {
        this.nome_categ = nome_categ;
    }

}
