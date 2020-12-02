package models;

public class Cliente {

    private int Id;
    private String Nome;
    private String Email;
    private String Telefone;

    public Cliente() {
    }

    public Cliente(int Id, String Nome, String Email, String Telefone) {
        this.Id = Id;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;

    }

    @Override
    public String toString() {
        return this.Id + " - " + this.Nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }    
    
}
