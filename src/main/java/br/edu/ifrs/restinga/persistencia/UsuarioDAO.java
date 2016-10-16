package br.edu.ifrs.restinga.persistencia;

import java.util.List;
import br.edu.ifrs.restinga.modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Morgana
 */
public class UsuarioDAO {
    private final Session sessao;
    
    public UsuarioDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void salvar(Usuario usuario) {
        sessao.saveOrUpdate(usuario);
    }
    
    public Usuario carregar(int id) {
        return (Usuario) sessao.load(Usuario.class, id);
    }
    
    public void remover(Usuario usuario) {
        sessao.delete(usuario);
    }
    
    public List<Usuario> listar() {
        return sessao.createCriteria(Usuario.class).list();
    }
    
    public Usuario consultaPorLoginESenha(String usuario, String senha) {
        Query consulta = sessao.createQuery("Select usuario FROM Usuario usuario WHERE  usuario.usuario = :usuario and usuario.senha = :senha");
        consulta.setString("usuario", usuario);
        consulta.setString("senha", senha);
        return (Usuario) consulta.uniqueResult();
    }
    
    public void encerrar() {
    }
}
