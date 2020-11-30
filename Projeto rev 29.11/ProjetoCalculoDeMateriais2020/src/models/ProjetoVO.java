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
public class ProjetoVO {
     private int id_proj;
    private int id_pcli;
    private int id_puser;
    private String nome_proj;
    private String art_proj;
    private String ender_proj;
    private String cidade_proj;
    private String nome_cli;

    public ProjetoVO() {
    }

    public ProjetoVO(int id_proj, int id_pcli, int id_puser, String nome_proj,
             String art_proj, String ender_proj, String cidade_proj, String nome_cli) {
        this.id_proj = id_proj;
        this.id_pcli = id_pcli;
        this.id_puser = id_puser;
        this.nome_proj = nome_proj;
        this.art_proj = art_proj;
        this.ender_proj = ender_proj;
        this.cidade_proj = cidade_proj;
        this.nome_cli = nome_cli;

    }
}
