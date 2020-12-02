package models;

public class Recorte {    
    private int Id;
    private float Altura;
    private float Largura;
    private String Descricao;
    private int IdObjeto;

    public Recorte() {
    }

    public Recorte(int id, String descricao, float altura,
            float largura, int idObjeto) {
        this.Id = id;
        this.Altura = altura;
        this.Largura = largura;
        this.Descricao = descricao;
        this.IdObjeto = idObjeto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public void setIdObjeto(int IdObjeto) {
        this.IdObjeto = IdObjeto;
    }
    
    public float GetArea() {
        return this.getAltura() * this.getLargura();
    }
    
}
