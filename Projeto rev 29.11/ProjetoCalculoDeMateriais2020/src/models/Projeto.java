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
public class Projeto {

    private int Código;
    private int id_cliente;
    private int id_puser;
    private String NomeProjeto;
    private String ART;
    private String Endereço;
    private String Cidade;

    public Projeto() {
    }

    public Projeto(int Código, int id_cliente, int id_puser, String NomeProjeto,
             String ART, String Endereço, String Cidade) {
        this.Código = Código;
        this.id_cliente = id_cliente;
        this.id_puser = id_puser;
        this.NomeProjeto = NomeProjeto;
        this.ART = ART;
        this.Endereço = Endereço;
        this.Cidade = Cidade;

    }

    /**
     * @return the Código
     */
    public int getCódigo() {
        return Código;
    }

    /**
     * @param Código the Código to set
     */
    public void setCódigo(int Código) {
        this.Código = Código;
    }

    /**
     * @return the id_pcli
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_pcli the id_pcli to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_puser
     */
    public int getId_puser() {
        return id_puser;
    }

    /**
     * @param id_puser the id_puser to set
     */
    public void setId_puser(int id_puser) {
        this.id_puser = id_puser;
    }

    /**
     * @return the NomeProjeto
     */
    public String getNomeProjeto() {
        return NomeProjeto;
    }

    /**
     * @param NomeProjeto the NomeProjeto to set
     */
    public void setNomeProjeto(String NomeProjeto) {
        this.NomeProjeto = NomeProjeto;
    }

    /**
     * @return the ART
     */
    public String getART() {
        return ART;
    }

    /**
     * @param ART the ART to set
     */
    public void setART(String ART) {
        this.ART = ART;
    }

    /**
     * @return the Endereço
     */
    public String getEndereço() {
        return Endereço;
    }

    /**
     * @param Endereço the Endereço to set
     */
    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return Cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

   

}
