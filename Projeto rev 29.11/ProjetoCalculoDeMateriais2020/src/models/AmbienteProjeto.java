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
public class AmbienteProjeto {

    private int id;
    private int id_projeto;
    private String nome;

    public AmbienteProjeto() {
    }

    public AmbienteProjeto(int id, String nome, int id_projeto) {
        this.id = id;
        this.id_projeto = id_projeto;
        this.nome = nome;

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_approj
     */
    public int getId_projeto() {
        return id_projeto;
    }

    /**
     * @param id_projeto the id_approj to set
     */
    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
