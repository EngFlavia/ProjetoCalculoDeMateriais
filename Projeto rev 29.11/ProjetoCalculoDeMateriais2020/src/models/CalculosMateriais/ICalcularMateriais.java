package models.CalculosMateriais;

import models.Material;

public interface ICalcularMateriais {
    
    public int CalcularQuantide(Material material, float areaUtil, int quantidadeDeMao);
            
    public float CalcularCusto(Material material, int quantidade);
    
    public float CalcularCustoMetro2(float custo, float areaUtil);
    
}
