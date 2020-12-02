package models;

import models.CalculosMateriais.FactoryCalculo;
import models.CalculosMateriais.ICalcularMateriais;

public class MaterialCalculado {    
    private int Id;
    private int Quantidade;
    private int QuantidadeDeMao;
    private float CustoTotal;
    private float CustoMetro2;
    private int IdMaterial;
    private int IdObjeto;
        
    public MaterialCalculado() {
    }

    public MaterialCalculado(Material material, float areaUtil, int quantidadeDeMao, int idObjeto)
    {
        this.Id = 0;        
        this.QuantidadeDeMao = quantidadeDeMao;
        this.IdMaterial = material.getId();        
        this.IdObjeto = idObjeto;
        
        Calcular(material, areaUtil, quantidadeDeMao);
    }
    
    public MaterialCalculado(int Id, int Quantidade, int QuantidadeDeMao,
            float CustoTotal, float CustoMetro2, int IdMaterial, int IdObjeto) {
        this.Id = Id;
        this.Quantidade = Quantidade;
        this.QuantidadeDeMao = QuantidadeDeMao;
        this.CustoTotal = CustoTotal;
        this.CustoMetro2 = CustoMetro2;
        this.IdMaterial = IdMaterial;
        this.IdObjeto = IdObjeto;
    }
    
    public void Calcular(Material material, float areaUtil, int quantidadeDeMao) {        
        ICalcularMateriais calculo = FactoryCalculo.GetInstance().ObterCalculo(material.getIdMaterialTipo());
        
        this.Quantidade = calculo.CalcularQuantide(material, areaUtil, quantidadeDeMao);
        this.CustoTotal = calculo.CalcularCusto(material, this.Quantidade);
        this.CustoMetro2 = calculo.CalcularCustoMetro2(this.CustoTotal, areaUtil);
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getQuantidadeDeMao() {
        return QuantidadeDeMao;
    }

    public void setQuantidadeDeMao(int QuantidadeDeMao) {
        this.QuantidadeDeMao = QuantidadeDeMao;
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public void setIdObjeto(int IdObjeto) {
        this.IdObjeto = IdObjeto;
    }    

    public float getCustoTotal() {
        return CustoTotal;
    }

    public void setCustoTotal(float CustoTotal) {
        this.CustoTotal = CustoTotal;
    }

    public float getCustoMetro2() {
        return CustoMetro2;
    }

    public void setCustoMetro2(float CustoMetro2) {
        this.CustoMetro2 = CustoMetro2;
    }
    
    
}
