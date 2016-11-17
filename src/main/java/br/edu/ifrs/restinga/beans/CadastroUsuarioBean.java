/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.beans;

/**
 *
 * @author Portal
 */

import br.edu.ifrs.restinga.modelo.Usuario;
import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;
import br.edu.ifrs.restinga.persistencia.UsuarioDAO;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name="usuarioBean")
@RequestScoped
public class CadastroUsuarioBean 
{
    private Usuario usuario = new Usuario();
    private UsuarioDAO dao;
    private List<Usuario> listaUsuarios;

    public CadastroUsuarioBean() 
    {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new UsuarioDAO(controleSessaoHibernate.getSession());
        listaUsuarios = dao.listar();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String salvar() 
    {
        boolean novo = usuario.ehNovo();
        dao.salvar(usuario);
        if(novo) 
	{
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Usuario cadastrado com sucesso");
            listaUsuarios.add(usuario);
            usuario = new Usuario();
            return null;
        } 
        else 
        {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Usuario atualizado com sucesso");
            return null;
        }
    }
    
    public void carregar(int id) {
        usuario = dao.carregar(id);
    }
    
    public void carregarNovo(int id) {
        usuario = new Usuario();
    }
    
    public void remover(Usuario usuario) {
        dao.remover(usuario);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Usuario removido com sucesso");
        listaUsuarios.remove(usuario);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
}

