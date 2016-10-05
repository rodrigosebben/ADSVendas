package br.edu.ifrs.restinga.modelo;

import java.util.Date;


public class Usuario {
    private int id;
    private int usuarioTipoId;
    private String nomeUsuario;
    private String login;
    private String senha;
    private Date dataCadastro;
    private int empresaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioTipoId() {
        return usuarioTipoId;
    }

    public void setUsuarioTipoId(int usuarioTipoId) {
        this.usuarioTipoId = usuarioTipoId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }
    
}
