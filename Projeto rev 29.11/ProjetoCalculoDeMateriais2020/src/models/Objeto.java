package models;

import java.util.ArrayList;

public class Objeto {        
    private int Id;
    private String Descricao;
    private float Altura;
    private float Largura;            
    private int IdAmbiente;

    public Objeto() {
    }

    public Objeto(int Id, String Descricao, int Altura,
            int Largura, int IdAmbiente) {
        this.Id = Id;
        this.Descricao = Descricao;
        this.Altura = Altura;
        this.Largura = Largura;        
        this.IdAmbiente = IdAmbiente;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getAltura() {
        return Altura;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    public float getLargura() {
        return Largura;
    }

    public void setLargura(float Largura) {
        this.Largura = Largura;
    }

    public int getIdAmbiente() {
        return IdAmbiente;
    }

    public void setIdAmbiente(int IdAmbiente) {
        this.IdAmbiente = IdAmbiente;
    }
       
    public float GetArea (){
        return this.getAltura() * this.getLargura();
    }
    
    public float GetAreaUtil (ArrayList<Recorte> recortes){
        float areaRecorte = 0;
        float area = GetArea();
        for(Recorte recorte : recortes)
        {
            areaRecorte += recorte.GetArea();
        }
        
        if(areaRecorte > area){
            return 0;
        }
            
        return area - areaRecorte;
    }
    
}
