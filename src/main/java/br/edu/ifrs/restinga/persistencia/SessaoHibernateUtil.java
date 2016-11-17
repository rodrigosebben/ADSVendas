package br.edu.ifrs.restinga.persistencia;

import org.hibernate.Session;

public class SessaoHibernateUtil {
    private Session sessaoHibernate;
    
    public void iniciarSessaoHibernate() {
        sessaoHibernate = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void iniciarTransacao() {
        sessaoHibernate.beginTransaction();
    }
    
    public void encerrarTransacao() {
        sessaoHibernate.getTransaction().commit();
    }
    
    public void encerrarSessaoHibernate() {
        sessaoHibernate.close();
    }

    public Session getSession() {
        return sessaoHibernate;
    }
}
