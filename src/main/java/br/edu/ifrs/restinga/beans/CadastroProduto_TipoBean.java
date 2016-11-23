package br.edu.ifrs.restinga.beans;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.edu.ifrs.restinga.modelo.Produto_tipo;
import br.edu.ifrs.restinga.persistencia.Produto_tipoDAO;
import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo Sebben
 */
@ManagedBean(name="produto_TipoBean")
@SessionScoped
public class CadastroProduto_TipoBean 
{
    private Produto_tipo produto_tipo = new Produto_tipo();
    private Produto_tipoDAO dao;
    private List<Produto_tipo> listaProduto_tipo;
    
    public CadastroProduto_TipoBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new Produto_tipoDAO(controleSessaoHibernate.getSession());
        listaProduto_tipo = dao.listar();
    }

    public Produto_tipo getProduto_tipo() {
        return produto_tipo;
    }

    public void setProdutoTipo(Produto_tipo produto_tipo) {
        this.produto_tipo = produto_tipo;
    }

    public List<Produto_tipo> getListaProduto_tipo() {
        return listaProduto_tipo;
    }

    public void setListaProduto_tipo(List<Produto_tipo> listaProduto_tipo) {
        this.listaProduto_tipo = listaProduto_tipo;
    }  
          
    public void novoProduto_tipo() {
        produto_tipo = new Produto_tipo();
    }
    
    public String salvar() 
    {
        boolean novo = produto_tipo.ehNovo();
        dao.salvar(produto_tipo);
        if(novo) 
	{
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Tipo de produto cadastrado com sucesso!");
            listaProduto_tipo.add(produto_tipo);
            produto_tipo = new Produto_tipo();
            return null;
        } 
        else 
        {
            enviarMensagem(FacesMessage.SEVERITY_INFO, "Tipo de produto atualizado com sucesso!");
            return null;
        }
    }

    public void carregar(int id) {
        produto_tipo = dao.carregar(id);
    }
    
    public void remover(Produto_tipo produto_tipo) {
        dao.remover(produto_tipo);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Tipo de produto removido com sucesso!");
        listaProduto_tipo.remove(produto_tipo);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }    
}
