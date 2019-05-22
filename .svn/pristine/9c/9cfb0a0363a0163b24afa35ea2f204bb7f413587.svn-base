package br.farn.folhacomercial.eco.negocioimpl;


import br.farn.folhacomercial.eco.dadosimpl.AbstractDao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;




@Component
public abstract class AbstractController<T> implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected T entidade;
	protected List<T> lista;
	protected DataModel<T> dataModel;
	protected ListDataModel<T> listDataModel;
	protected AbstractDao<T> dao;
	protected Class<T> clazz;
	protected String clazzdao;
	
    @Autowired
    private ApplicationContext contexto;

    public AbstractController() {
        super();
        instanciarEntidade();
    }

    @SuppressWarnings("unchecked")
	@PostConstruct
    public void iniciarInstanciaDao() {
        clazz = (Class<T>) getType();
        clazzdao = clazz.getSimpleName() + "Dao";
        dao = (AbstractDao<T>) contexto.getBean(clazzdao);
    }

    private Type getType() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return superclass.getActualTypeArguments()[0];
    }
    
//******************************************************	
    protected abstract void instanciarEntidade();

    protected abstract long getEntidadeId(T entidade);
    
 //****************************************************
    public void salvar(T entidade) {
        dao.salvar (entidade);
    }
 
    public void remover(T entidade) {
        dao.remover (entidade);
    }

     public void editar(T entidade) {
        dao.editar (entidade);
    }
  
    public List<T> buscarTodos() {
        return dao.buscarTodos();
    }
    
//******************************************************
	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

	
 
}
