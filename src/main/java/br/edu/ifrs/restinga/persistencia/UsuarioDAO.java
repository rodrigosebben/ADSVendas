/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.persistencia;

import org.hibernate.Session;
import java.util.List;
import br.edu.ifrs.restinga.modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Morgana
 */
public class UsuarioDAO {
    private Session sessao;
    
    public UsuarioDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Usuario usuario) {
        sessao.saveOrUpdate(usuario);
    }
    
    public Usuario carregar(int id) {
        return (Usuario) sessao.load(Usuario.class, id);
    }
    
    public void remover(Usuario usuario) {
        sessao.delete(usuario);
    }
    
    public List<Usuario> listar() {
        return sessao.createCriteria(Usuario.class).list();
    }
    
    public Usuario consultaPorLoginESenha(String login, String senha) {
        Query consulta = sessao.createQuery("FROM Usuario WHERE login = :login and senha = :senha");
        consulta.setString("login", login);
        consulta.setString("senha", senha);
        return (Usuario) consulta.uniqueResult();
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
}
