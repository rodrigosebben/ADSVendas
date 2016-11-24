//SUBSTITUIR POR FORNECEDOR
package br.edu.ifrs.restinga.persistencia;

import java.util.List;
import br.edu.ifrs.restinga.modelo.Fornecedor;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Morgana
 */
public class FornecedorDAO 
{
    private final Session sessao;

    public FornecedorDAO (Session sessao) 
    {
        this.sessao = sessao;
    }
    
    public void salvar(Fornecedor fornecedor) 
    {
        sessao.saveOrUpdate(fornecedor);
    }
    
    public Fornecedor carregar(int id) 
    {
        return (Fornecedor) sessao.load(Fornecedor.class, id);
    }
  
    public void remover(Fornecedor fornecedor) 
    {
        sessao.delete(fornecedor);
    }
    
    public List<Fornecedor> listar() 
    {
        return sessao.createCriteria(Fornecedor.class).list();
    }

    public Fornecedor consultaPorFornecedor(String fornecedor) 
    {
        Query consulta = sessao.createQuery("FROM Fornecedor WHERE nomeFornecedor = :fornecedor");
        consulta.setString("fornecedor", fornecedor);
        return (Fornecedor) consulta.uniqueResult();
    }
    
}
