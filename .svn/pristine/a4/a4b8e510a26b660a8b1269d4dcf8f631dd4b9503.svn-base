package br.farn.folhacomercial.eco.view;

import java.util.List;

import javax.inject.Inject;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Cargo;
import br.farn.folhacomercial.eco.negocio.ControllerCargo;


@Component
@Scope("session")
public class CargoBean extends AbstractCrudMBean<Cargo>{

	private List<Cargo> cargos;
	
	public CargoBean (){
		super();
	}
	
	
	@Inject
    private ControllerCargo controller;
	
	
	
	public List<Cargo> getCargos() {
		this.cargos = controller.buscarTodos();
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

		
	@Override
	protected void limparFormulario() {
		entidade = new Cargo();
		
	}
	
	

}
