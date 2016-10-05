/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifrs.restinga.persistencia.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.edu.ifrs.restinga.modelo.Usuario;

/**
 *
 * @author Morgana
 */
@ManagedBean
@SessionScoped
public class SessaoUsuarioBean {
    private String login;
    private String senha;
    private Usuario usuarioLogado;

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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public String fazerLogin() {
        UsuarioDAO dao = new UsuarioDAO();
        usuarioLogado = dao.consultaPorLoginESenha(login, senha);
        dao.encerrar();
        if(usuarioLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos!", ""));
            return null;
        } else {
            return "index";
        }
    }
    
    public String logout() {
        usuarioLogado = null;
        return "login";
    }
    
    public boolean temUsuarioLogado() {
        return usuarioLogado != null;
    }
}
