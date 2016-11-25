//SUBSTITUIR POR EMPRESA POR FORNECEDOR

package br.edu.ifrs.restinga.beans;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.edu.ifrs.restinga.modelo.Fornecedor;
import br.edu.ifrs.restinga.persistencia.FornecedorDAO;
import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morgana
 */
@ManagedBean(name="fornecedorBean")
@SessionScoped
public class CadastroFornecedorBean 
{
    private Fornecedor fornecedor = new Fornecedor();
    private FornecedorDAO dao;
    private List<Fornecedor> listaFornecedores;
    
    public CadastroFornecedorBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new FornecedorDAO(controleSessaoHibernate.getSession());
        listaFornecedores = dao.listar();
    }
          
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }

    public void novoFornecedor() {
        fornecedor = new Fornecedor();
    }
    
    public String salvar() 
    {
        boolean novo = fornecedor.ehNovo();
        dao.salvar(fornecedor);
        if(novo) 
	{
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Fornecedor cadastrado com sucesso");
            listaFornecedores.add(fornecedor);
            fornecedor = new Fornecedor();
            return null;
        } 
        else 
        {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Fornecedor atualizado com sucesso");
            return null;
        }
    }

    public void carregar(int id) {
        fornecedor = dao.carregar(id);
    }
    
    public void remover(Fornecedor fornecedor) {
        dao.remover(fornecedor);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Fornecedor removido com sucesso");
        listaFornecedores.remove(fornecedor);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
        
}
