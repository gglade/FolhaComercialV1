package br.farn.folhacomercial.eco.view;

import br.farn.folhacomercial.eco.negocioimpl.AbstractController;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.ListDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
public abstract class AbstractCrudMBean<T> {

	protected T entidade;
	protected List<T> lista;
	protected AbstractController<T> controller;
	protected ListDataModel<T> dataModel;
	protected Class<T> clazz;
	protected String clazzger;

	@Autowired
	private ApplicationContext contexto;

	public AbstractCrudMBean() {
		super();
		limparFormulario();

	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void iniciarInstanciaGerenciador() {
		clazz = (Class<T>) getType();
		clazzger = "controller" + clazz.getSimpleName() + "Impl";
		controller = (AbstractController<T>) contexto.getBean(clazzger);
	}

	private Type getType() {
		ParameterizedType superclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return superclass.getActualTypeArguments()[0];
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

	public String salvar() {
		controller.salvar(entidade);
		limparFormulario();
		return null;
	}

	public String alterar() {
		// entidade = dataModel.getRowData();
		controller.editar(entidade);
		limparFormulario();
		listar();
		return null;
	}

	public String listar() {
		limparFormulario();
		this.lista = controller.buscarTodos();

		return getPastaEntidade() + "listagem.xhtml";
	}

	protected String getPastaEntidade() {
		return "app/" + entidade.getClass().getSimpleName().toLowerCase() + "/";
	}

	public String excluir() {
		entidade = dataModel.getRowData();
		controller.remover(entidade);
		limparFormulario();
		listar();
		return null;
	}

	protected abstract void limparFormulario();

	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public ListDataModel<T> getDataModel() {
		return dataModel;
	}

	public void setDataModel(ListDataModel<T> dataModel) {
		this.dataModel = dataModel;
	}

}