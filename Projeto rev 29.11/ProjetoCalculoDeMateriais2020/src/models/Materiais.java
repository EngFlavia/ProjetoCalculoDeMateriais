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
public class Materiais {

    private int id_mat;
    private String nome_mat;
    private int id_mcateg;
    float qntVenda_mat;
    float qntRendimento_mat;
    float Custo_mat;
    float areaObjeto;
    float Quebra_mat;

    public Materiais() {
    }

    public Materiais(int id_mat, String nome_mat, int id_mcateg, float qntVenda_mat,
            float qntRendimento_mat, float Custo_mat, float Quebra_mat) {
        this.id_mat = id_mat;
        this.nome_mat = nome_mat;
        this.id_mcateg = id_mcateg;
        this.qntVenda_mat = qntVenda_mat;
        this.qntRendimento_mat = qntRendimento_mat;
        this.Custo_mat = Custo_mat;
        this.Quebra_mat = Quebra_mat;

    }
    @Override
    public String toString() {
        return id_mat + " - " + nome_mat;
    }
    /**
     * @return the id_mat
     */
    public int getId_mat() {
        return id_mat;
    }

    /**
     * @param id_mat the id_mat to set
     */
    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    /**
     * @return the nome_mat
     */
    public String getNome_mat() {
        return nome_mat;
    }

    /**
     * @param nome_mat the nome_mat to set
     */
    public void setNome_mat(String nome_mat) {
        this.nome_mat = nome_mat;
    }

    /**
     * @return the id_mcateg
     */
    public int getId_mcateg() {
        return id_mcateg;
    }

    /**
     * @param id_mcateg the id_mcateg to set
     */
    public void setId_mcateg(int id_mcateg) {
        this.id_mcateg = id_mcateg;
    }

    /**
     * @return the qntVenda_mat
     */
    public float getQntVenda_mat() {
        return qntVenda_mat;
    }

    /**
     * @param qntVenda_mat the qntVenda_mat to set
     */
    public void setQntVenda_mat(float qntVenda_mat) {
        this.qntVenda_mat = qntVenda_mat;
    }

    /**
     * @return the qntRendimento_mat
     */
    public float getQntRendimento_mat() {
        return qntRendimento_mat;
    }

    /**
     * @param qntRendimento_mat the qntRendimento_mat to set
     */
    public void setQntRendimento_mat(float qntRendimento_mat) {
        this.qntRendimento_mat = qntRendimento_mat;
    }

    /**
     * @return the Custo_mat
     */
    public float getCusto_mat() {
        return Custo_mat;
    }

    /**
     * @param Custo_mat the Custo_mat to set
     */
    public void setCusto_mat(float Custo_mat) {
        this.Custo_mat = Custo_mat;
    }

    /**
     * @return the Quebra_mat
     */
    public float getQuebra_mat() {
        return Quebra_mat;
    }

    /**
     * @param Quebra_mat the Quebra_mat to set
     */
    public void setQuebra_mat(float Quebra_mat) {
        this.Quebra_mat = Quebra_mat;
    }

    public float getAreaObjeto() {
        return areaObjeto;
    }

    public void setAreaObjeto(float areaObjeto) {
        this.areaObjeto = areaObjeto;
    }   
    

     public float AreaMaterial(){
        
        return(1);
    }
        
}
