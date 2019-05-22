package br.farn.folhacomercial.eco.view;

import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Cargo;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.negocio.ControllerEmpresa;

@Component
@Scope("session")
public class EmpresaBean extends AbstractCrudMBean<Empresa> {

	private List<Empresa> empresas;

	public EmpresaBean() {
		super();
		limparFormulario();
	}

	@Inject
	private ControllerEmpresa controller;

	@Override
	protected void limparFormulario() {
		entidade = new Empresa();

	}

	public ListDataModel<Empresa> getDataModel() {
		dataModel = new ListDataModel<Empresa>(controller.buscarTodos());
		return dataModel;
	}

	public List<Empresa> getEmpresas() {
		this.empresas = controller.buscarTodos();
		return empresas;
	}
	
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public String prepararAlterar() {
		// limparFormulario();
		entidade = dataModel.getRowData();
		return null;
	}

	 

}
