/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author ngarcia
 */
public class ObjetoCalculoMaterial { 
    private int id_objCalcMat;
    private float altura;
    private float largura;    
    private float areaRecorte; 
    private String nome_objCalcMat;
    private int id_ambiente;

    public ObjetoCalculoMaterial() {
    }

    public ObjetoCalculoMaterial(int id_objCalcMat, String nome_objCalcMat, int altura,
            int largura, int id_ambiente) {
        this.id_objCalcMat = id_objCalcMat;
        this.altura = altura;
        this.largura = largura;
        this.nome_objCalcMat = nome_objCalcMat;
        this.id_ambiente = id_ambiente;
    }

    /**
     * @return the id_objCalcMat
     */
    public int getId_objCalcMat() {
        return id_objCalcMat;
    }

    /**
     * @param id_objCalcMat the id_objCalcMat to set
     */
    public void setId_objCalcMat(int id_objCalcMat) {
        this.id_objCalcMat = id_objCalcMat;
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
     * @return the nome_objCalcMat
     */
    public String getNome_objCalcMat() {
        return nome_objCalcMat;
    }

    /**
     * @param nome_objCalcMat the nome_objCalcMat to set
     */
    public void setNome_objCalcMat(String nome_objCalcMat) {
        this.nome_objCalcMat = nome_objCalcMat;
    }

    /**
     * @return the id_ambiente
     */
    public int getId_ambiente() {
        return id_ambiente;
    }   

    /**
     * @param id_ambiente the id_ambiente to set
     */
    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }
        
    public float CalcularArea(){              
        return (largura * altura);
    }
    
    public float CalcularAreaUtil(ArrayList<ObjetoCalculoMaterialRecorte> listaRecorte){              
      float area = CalcularArea();             
      float totalAreaRecorte = 0;

      for (ObjetoCalculoMaterialRecorte recorte : listaRecorte) {
          totalAreaRecorte += recorte.CalcularArea();
      }

      return area - totalAreaRecorte;
    }    
    
}
