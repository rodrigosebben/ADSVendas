package br.edu.ifrs.restinga.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;

/**
 *
 * @author Morgana
 */
@WebFilter(filterName = "FiltroTransacao", urlPatterns = {"*.xhtml"})
public class FiltroTransacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessaoHTTP = httpRequest.getSession();
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        controleSessaoHibernate.iniciarTransacao(); 
        chain.doFilter(request, response);
        controleSessaoHibernate.encerrarTransacao();
    }

    @Override
    public void destroy() 
    {
       
    }
    
}

