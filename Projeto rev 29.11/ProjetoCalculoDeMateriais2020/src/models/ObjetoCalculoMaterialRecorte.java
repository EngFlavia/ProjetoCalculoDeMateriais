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
public class ObjetoCalculoMaterialRecorte {
    
    private int id;
    private float altura;
    private float largura;
    private String nome;
    private int id_Objeto;

    public ObjetoCalculoMaterialRecorte() {
    }

    public ObjetoCalculoMaterialRecorte(int id, String nome, int altura,
            int largura, int id_Objeto) {
        this.id = id;
        this.altura = altura;
        this.largura = largura;
        this.nome = nome;
        this.id_Objeto = id_Objeto;

    }

    /**
     * @return the id_objCalcMat
     */
    public int getId() {
        return id;
    }

    /**
     * @param id_objCalcMat the id_objCalcMat to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public float getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(float largura) {
        this.largura = largura;
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

    /**
     * @return the id_Objeto
     */
    public int getId_Objeto() {
        return id_Objeto;
    }

    /**
     * @param id_Objeto the id_Objeto to set
     */
    public void setId_Objeto(int id_Objeto) {
        this.id_Objeto = id_Objeto;
    }
    
    public float CalcularArea(){        
        return (largura * altura);
    }      
    
}
