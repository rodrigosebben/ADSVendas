
import br.edu.ifrs.restinga.persistencia.SessaoHibernateUtil;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessaoHTTPListener implements HttpSessionListener {
    private SessaoHibernateUtil controleSessaoHibernate;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        controleSessaoHibernate = new SessaoHibernateUtil();
        controleSessaoHibernate.iniciarSessaoHibernate();
        se.getSession().setAttribute("controleSessaoHibernate", controleSessaoHibernate);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        controleSessaoHibernate.encerrarSessaoHibernate();
    }
}
