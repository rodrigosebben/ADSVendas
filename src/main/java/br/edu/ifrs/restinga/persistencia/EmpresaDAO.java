package br.edu.ifrs.restinga.persistencia;

import java.util.List;
import br.edu.ifrs.restinga.modelo.Empresa;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Rodrigo
 */
public class EmpresaDAO 
{
    private Session sessao;

    public EmpresaDAO() 
    {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Empresa empresa) 
    {
        sessao.saveOrUpdate(empresa);
    }
    
    public Empresa carregar(int id) 
    {
        return (Empresa) sessao.load(Empresa.class, id);
    }
    
    public void remover(Empresa empresa) 
    {
        sessao.delete(empresa);
    }
    
    public List<Empresa> listar() 
    {
        return sessao.createCriteria(Empresa.class).list();
    }

    public Empresa consultaPorEmpresa(String empresa) 
    {
        Query consulta = sessao.createQuery("Select * FROM Empresa empresa WHERE empresa.nomeEmpresa = :empresa");
        consulta.setString("empresa", empresa);
        return (Empresa) consulta.uniqueResult();
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
    
}
