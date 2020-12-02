package models.CalculosMateriais;

import models.Material;

public class CalculoQuantitativoMateriais implements ICalcularMateriais {

    @Override
    public int CalcularQuantide(Material material, float areaUtil, int quantidadeDeMao) {        
        return (int)(areaUtil * quantidadeDeMao / material.getRendimento());                
    }

    @Override
    public float CalcularCusto(Material material, int quantidade) {        
        double quantida = Math.ceil(quantidade / material.getQuantidadeLote());
        return (float)quantida * material.getCusto();
    }
    
    @Override
    public float CalcularCustoMetro2(float custo, float areaUtil) {
        return  custo / areaUtil;
    }
    
}
