//SUBSTITUIR POR EMPRESA POR FORNECEDOR

//package br.edu.ifrs.restinga.beans;
//
//import java.util.List;
//import javax.annotation.PreDestroy;
//import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage.Severity;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import br.edu.ifrs.restinga.modelo.Empresa;
//import br.edu.ifrs.restinga.persistencia.EmpresaDAO;
//import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;
//import javax.faces.bean.SessionScoped;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author Morgana
// */
//@ManagedBean(name="empresaBean")
//@SessionScoped
//public class CadastroEmpresaBean 
//{
//    private Empresa empresa = new Empresa();
//    private EmpresaDAO dao;
//    private List<Empresa> listaEmpresas;
//    
//    public CadastroEmpresaBean() {
//        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
//        dao = new EmpresaDAO(controleSessaoHibernate.getSession());
//        listaEmpresas = dao.listar();
//    }
//          
//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }
//
//    public List<Empresa> getListaEmpresas() {
//        return listaEmpresas;
//    }
//
//    public void setListaEmpresas(List<Empresa> listaEmpresas) {
//        this.listaEmpresas = listaEmpresas;
//    }
//
//    public void novaEmpresa() {
//        empresa = new Empresa();
//    }
//    
//    public String salvar() 
//    {
//        boolean novo = empresa.ehNovo();
//        dao.salvar(empresa);
//        if(novo) 
//	{
//            enviarMensagem(FacesMessage.SEVERITY_INFO, "Empresa cadastrada com sucesso");
//            listaEmpresas.add(empresa);
//            empresa = new Empresa();
//            return null;
//        } 
//        else 
//        {
//            enviarMensagem(FacesMessage.SEVERITY_INFO, "Empresa atualizada com sucesso");
//            return null;
//        }
//    }
//
//    public void carregar(int id) {
//        empresa = dao.carregar(id);
//    }
//    
//    public void remover(Empresa empresa) {
//        dao.remover(empresa);
//        enviarMensagem(FacesMessage.SEVERITY_INFO, "Empresa removida com sucesso");
//        listaEmpresas.remove(empresa);
//    }
//    
//    private void enviarMensagem(Severity sev, String msg) {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage(null, new FacesMessage(sev, msg, ""));
//    }
//        
//}
