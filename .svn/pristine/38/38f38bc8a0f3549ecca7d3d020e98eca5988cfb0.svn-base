package br.farn.folhacomercial.eco.view;


import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Cargo;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.negocio.ControllerFuncionario;




@Component
@Scope("session")
public class FuncionarioBean extends AbstractCrudMBean<Funcionario>{
	
	private List<Funcionario> funcionarios;
	private int empresaSelecionada;
	private ListDataModel<Funcionario> listCodFunc;
	private Funcionario funcionario = new Funcionario();
	String login = SecurityContextHolder.getContext().getAuthentication().getName();

	public FuncionarioBean (){
		super();
		limparFormulario();
	}
	
	@Inject
    private ControllerFuncionario controller;

	@Override
	protected void limparFormulario() {
		 entidade = new Funcionario();
		 entidade.setCargo(new Cargo());
		 entidade.setEmpresa(new Empresa());		
	}

	public ListDataModel<Funcionario> getDataModel() {
		dataModel = new ListDataModel<Funcionario>(controller.buscarTodos());
		return dataModel;
	}
	
	public List<Funcionario> buscarPorEmpresa(){
		lista = controller.buscarPorEmpresa1(entidade);
		return lista;
	}
	
		
	public List<Funcionario> getFuncionarios() {
		this.funcionarios = controller.buscarTodos();
		return funcionarios;
		
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	  public String carregarFuncionario() {
	        entidade = controller.buscarPorId(entidade);
	        return null;
	    }

	/*
	 * Testes
	 */

	public int getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(int empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public void actionCarregarFuncionarios() {  
		   this.listCodFunc =  getListCodFunc();  
		}  

	public ListDataModel<Funcionario> getListCodFunc() {
		  List<Funcionario> funcionarios;
		   if(empresaSelecionada != 0){  
			  funcionarios = controller.buscarPorEmpresa(getEmpresaSelecionada());
		      listCodFunc = new ListDataModel<Funcionario>(funcionarios) ;  
		      return  listCodFunc;  
		   }  
		   return null;
	}

	public void setListCodFunc(ListDataModel<Funcionario> listCodFunc) {
		this.listCodFunc = (ListDataModel<Funcionario>) listCodFunc;
	}

	public ControllerFuncionario getController() {
		return controller;
	}

	public void setController(ControllerFuncionario controller) {
		this.controller = controller;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	  
}
