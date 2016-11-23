package br.edu.ifrs.restinga.persistencia;

import java.util.List;
import br.edu.ifrs.restinga.modelo.Produto_tipo;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rodrigo Sebben
 */
public class Produto_tipoDAO 
{
    private final Session sessao;

    public Produto_tipoDAO(Session sessao) 
    {
        this.sessao = sessao;
    }
    
    public void salvar(Produto_tipo produto_tipo) 
    {
        sessao.saveOrUpdate(produto_tipo);
    }
    
    public Produto_tipo carregar(int id) 
    {
        return (Produto_tipo) sessao.load(Produto_tipo.class, id);
    }
  
    public void remover(Produto_tipo produto_tipo) 
    {
        sessao.delete(produto_tipo);
    }
    
    public List<Produto_tipo> listar() 
    {
        return sessao.createCriteria(Produto_tipo.class).list();
    }

    public Produto_tipo consultaPorEmpresa(String produto_tipo) 
    {
        Query consulta = sessao.createQuery("FROM produto_tipo WHERE NomeTipo_Produto = :tipo");
        consulta.setString("tipo", produto_tipo);
        return (Produto_tipo) consulta.uniqueResult();
    }    
}
