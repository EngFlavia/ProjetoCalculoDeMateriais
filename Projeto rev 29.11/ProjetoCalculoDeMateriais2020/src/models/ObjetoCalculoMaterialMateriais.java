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
public class ObjetoCalculoMaterialMateriais extends Materiais{

    private int id_ocm;
    private int quantidade;
    private int id_ocmMat;
    private int id_ocmMatCalc;
    private int qntDmao_ocm;
    
    public ObjetoCalculoMaterialMateriais() {
    }

    public ObjetoCalculoMaterialMateriais(int id_ocm, int qntDmao_ocm, int quantidade,
            int id_ocmMat, int id_ocmMatCalc) {
        this.id_ocm = id_ocm;
        this.id_ocmMat = id_ocmMat;
        this.qntDmao_ocm = qntDmao_ocm;
        this.quantidade = quantidade;
        this.id_ocmMatCalc = id_ocmMatCalc;

    }

    /**
     * @return the id_ocm
     */
    public int getId_ocm() {
        return id_ocm;
    }

    /**
     * @param id_ocm the id_ocm to set
     */
    public void setId_ocm(int id_ocm) {
        this.id_ocm = id_ocm;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the id_ocmMat
     */
    public int getId_ocmMat() {
        return id_ocmMat;
    }

    /**
     * @param id_ocmMat the id_ocmMat to set
     */
    public void setId_ocmMat(int id_ocmMat) {
        this.id_ocmMat = id_ocmMat;
    }

    /**
     * @return the id_ocmMatCalc
     */
    public int getId_ocmMatCalc() {
        return id_ocmMatCalc;
    }

    /**
     * @param id_ocmMatCalc the id_ocmMatCalc to set
     */
    public void setId_ocmMatCalc(int id_ocmMatCalc) {
        this.id_ocmMatCalc = id_ocmMatCalc;
    }

    /**
     * @return the qntDmao_ocm
     */
    public int getQntDmao_ocm() {
        return qntDmao_ocm;
    }

    /**
     * @param qntDmao_ocm the qntDmao_ocm to set
     */
    public void setQntDmao_ocm(int qntDmao_ocm) {
        this.qntDmao_ocm = qntDmao_ocm;
    }  
    
    public float QuantidadeCompraTinta(){
        float totalCalculado = (areaObjeto / qntRendimento_mat)* qntDmao_ocm;
        float totalComprar = (totalCalculado * Quebra_mat) + totalCalculado;
        
        return(totalComprar );
    } 
    
    public float ValorTinta(){
        float valorUnitario = qntVenda_mat / Custo_mat;
        float ValorCompra = (float) (Math.ceil(QuantidadeCompraTinta()) * valorUnitario);
        return (ValorCompra);
    }
    
    public float CustoM2(){        
        return(ValorTinta()/areaObjeto);
    }

    
}
