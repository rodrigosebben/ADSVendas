package br.edu.ifrs.restinga.beans;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.edu.ifrs.restinga.modelo.Empresa;
import br.edu.ifrs.restinga.persistencia.EmpresaDAO;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo
 */
@ManagedBean(name="empresaBean")
@SessionScoped
public class CadastroEmpresaBean 
{
    private Empresa empresa = new Empresa();
    private EmpresaDAO dao = new EmpresaDAO();
    private boolean ver;
    private List<Empresa> listaEmpresas;
    
    public void novaEmpresa()
    {
        this.ver = false;        
        this.empresa = new Empresa();
        resetarFormulario();
    }
    
    public void resetarFormulario() {
        EmpresaDAO.resetarFormulario("criar");
    }
    

    public CadastroEmpresaBean() {
        listaEmpresas = dao.listar();
    }    
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public void salvar() {
        dao.salvar(empresa);
        listaEmpresas.add(empresa);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Empresa cadastrada com sucesso");
    }

    public void carregar(int id) {
        empresa = dao.carregar(id);
    }
    
    public void remover(Empresa empresa) {
        dao.remover(empresa);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Empresa removida com sucesso");
        listaEmpresas.remove(empresa);
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
    @PreDestroy
    public void encerrar() {
        dao.encerrar();
    }
    
}
