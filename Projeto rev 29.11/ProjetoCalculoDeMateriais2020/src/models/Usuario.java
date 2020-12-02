/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ngarcia
 */
public class Usuario {
    private int Id;
    private String Login;
    private String Senha;
    private String Email;
    private String Telefone;
        
    public Usuario(int Id, String Login, String Senha, String Email,
            String Telefone){
        this.Id = Id;
        this.Login = Login;
        this.Senha = Senha;
        this.Email = Email;
        this.Telefone = Telefone;    
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
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
