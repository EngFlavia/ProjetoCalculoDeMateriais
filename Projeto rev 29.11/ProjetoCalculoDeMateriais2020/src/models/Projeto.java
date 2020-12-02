package models;

public class Projeto {

    private int Id;   
    private int IdCliente;
    private int IdUsuario;
    private String Descricao;
    private String ART;
    private String Endereco;
    private String Cidade;
    
    public Projeto(int id, int idCliente, int idUsuario, String descricao,
             String art, String endereco, String cidade) {
        this.Id = id;
        this.IdCliente = idCliente;
        this.IdUsuario = idUsuario;
        this.Descricao = descricao;
        this.ART = art;
        this.Endereco = endereco;
        this.Cidade = cidade;
    }       
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getART() {
        return ART;
    }

    public void setART(String ART) {
        this.ART = ART;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

}
