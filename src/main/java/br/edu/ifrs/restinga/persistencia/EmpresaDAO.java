package br.edu.ifrs.restinga.persistencia;

import java.util.List;
import br.edu.ifrs.restinga.modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.context.RequestContext;
/**
 *
 * @author Rodrigo
 */
public class EmpresaDAO 
{
     public void salvar(Empresa empresa) 
    {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.saveOrUpdate(empresa);
    }
    
    public Empresa carregar(int id) 
    {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Empresa) sessao.load(Empresa.class, id);
    }

    public static void resetarFormulario(String id) 
    {
        RequestContext.getCurrentInstance().reset(id);
    }
    
    public void remover(Empresa empresa) 
    {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(empresa);
    }
    
    public List<Empresa> listar() 
    {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Empresa.class).list();
    }

    public Empresa consultaPorEmpresa(String empresa) 
    {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Query consulta = sessao.createQuery("Select * FROM Empresa empresa WHERE empresa.nomeEmpresa = :empresa");
        consulta.setString("empresa", empresa);
        return (Empresa) consulta.uniqueResult();
    }
    
    public void encerrar() {
       
    }
    
}
