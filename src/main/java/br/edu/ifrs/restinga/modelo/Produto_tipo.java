/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.modelo;

/**
 *
 * @author rodrigo
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto_tipo")
public class Produto_tipo implements Serializable 
{
    @Id
    @GeneratedValue
    private int id;
    private String nomeTipo_Produto;
    private int Empresa_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresa_id() {
        return Empresa_id;
    }

    public void setEmpresa_id(int Empresa_id) {
        this.Empresa_id = 1;
    }
    
    public boolean ehNovo() {
        return id == 0;
    }    

    public String getNomeTipo_Produto() {
        return nomeTipo_Produto;
    }

    public void setNomeTipo_Produto(String nomeTipo_Produto) {
        this.nomeTipo_Produto = nomeTipo_Produto;
    }
    
}
