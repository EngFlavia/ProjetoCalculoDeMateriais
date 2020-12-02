package models;

public class Ambiente {

    private int Id;
    private int IdProjeto;
    private String Descricao;

    public Ambiente() {
    }
    
    public Ambiente(int Id, String Descricao, int IdProjeto) {
        this.Id = Id;
        this.IdProjeto = IdProjeto;
        this.Descricao = Descricao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdProjeto() {
        return IdProjeto;
    }

    public void setIdProjeto(int IdProjeto) {
        this.IdProjeto = IdProjeto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
}
