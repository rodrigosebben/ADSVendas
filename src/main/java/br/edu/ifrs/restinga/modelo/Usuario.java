package br.edu.ifrs.restinga.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    private int usuario_Tipo_Id;
    private String nomeUsuario;
    private String usuario;
    private String senha;
    private Date dataCadastro;
    private int empresa_Id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_Tipo_Id() {
        return usuario_Tipo_Id;
    }

    public void setUsuario_Tipo_Id(int usuario_Tipo_Id) {
        this.usuario_Tipo_Id = usuario_Tipo_Id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getEmpresa_Id() {
        return empresa_Id;
    }

    public void setEmpresa_Id(int empresa_Id) {
        this.empresa_Id = empresa_Id;
    }
    
}
