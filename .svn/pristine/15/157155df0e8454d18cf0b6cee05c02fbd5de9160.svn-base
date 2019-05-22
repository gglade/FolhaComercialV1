package br.farn.folhacomercial.eco.dadosimpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


@Component
public abstract class AbstractDao<T> {
	

	@Inject
	protected SessionFactory sessionFactory;
	
	@Inject
	private HibernateTemplate ht;
	

    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        clazz = (Class<T>) getType();        
    }
    
    
    private  Type getType() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return superclass.getActualTypeArguments()[0];
    }
    
//*******************************************
     public void salvar(T entidade) {
       
        ht.saveOrUpdate(entidade);
       
    }

    public void remover(T entidade) {
        ht.delete(entidade);
    }

    public void editar(T entidade) {
        ht.update(entidade);
    }
    
    public  T findById(long id) {
        return (T) ht.get(clazz, id);
    }


    public List<T> buscarTodos() {
        return ht.loadAll(clazz);
    }

    public Session getSession() {
		return sessionFactory.openSession();
	}
}
