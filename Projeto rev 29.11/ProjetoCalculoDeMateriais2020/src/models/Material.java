package models;

public class Material {

    private int Id;
    private String Descricao;
    private float Altura;
    private float Largura;
    private float QuantidadeLote;
    private float Rendimento;
    private float Custo;    
    private float Quebra;
    private int IdMaterialTipo;

    public Material() {
    }

    public Material(int id, int idMaterialTipo, String descricao,
            float altura, float largura, float quantidadeLote, 
            float rendimento, float custo, float quebra) {
        
        this.Id = id;
        this.Descricao = descricao;
        this.Altura = altura;
        this.Largura = largura;        
        this.QuantidadeLote = quantidadeLote;
        this.Rendimento = rendimento;
        this.Custo = custo;
        this.Quebra = quebra;
        this.IdMaterialTipo = idMaterialTipo;        

    }
    
    @Override
    public String toString() {
        return this.Id + " - " + this.Descricao;
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

    public int getIdMaterialTipo() {
        return IdMaterialTipo;
    }

    public void setIdMaterialTipo(int IdMaterialTipo) {
        this.IdMaterialTipo = IdMaterialTipo;
    }

    public float getQuantidadeLote() {
        return QuantidadeLote;
    }

    public void setQuantidadeLote(float QuantidadeLote) {
        this.QuantidadeLote = QuantidadeLote;
    }

    public float getRendimento() {
        return Rendimento;
    }

    public void setRendimento(float Rendimento) {
        this.Rendimento = Rendimento;
    }

    public float getCusto() {
        return Custo;
    }

    public void setCusto(float Custo) {
        this.Custo = Custo;
    }

    public float getQuebra() {
        return Quebra;
    }

    public void setQuebra(float Quebra) {
        this.Quebra = Quebra;
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
   
            
}
