package models.CalculosMateriais;

public class FactoryCalculo {    
    
    private static FactoryCalculo factoryCalculo;
    
    private FactoryCalculo() 
    {
    
    }
    
    public static FactoryCalculo GetInstance()
    {
        if(factoryCalculo==null)
        {
            factoryCalculo = new FactoryCalculo();
        }
        
        return factoryCalculo;
    }
            
    public ICalcularMateriais ObterCalculo(int tipoMaterial) {
    
        switch(tipoMaterial) 
        {
            case 1: //CATEGORIA_1
                return new CalculoQuantitativoMateriais();             
                        
            default:
                return new CalculoQuantitativoMateriais();                             
        }                      
    }
    
}
