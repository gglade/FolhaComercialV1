package br.farn.folhacomercial.eco.negocioimpl;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.CargoDaoImpl;
import br.farn.folhacomercial.eco.dominio.Cargo;
import br.farn.folhacomercial.eco.negocio.ControllerCargo;

@ManagedBean
@Component
@Scope ("session")
public class ControllerCargoImpl extends AbstractController<Cargo> implements ControllerCargo{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ControllerCargoImpl(){
		
		super();
		instanciarEntidade();
	}
	
	
	@Inject
	private CargoDaoImpl dao;
	

	public Cargo buscarPorId(Cargo entidade) {
		return dao.findById(entidade.getId());
	}

	@Override
	protected void instanciarEntidade() {
		entidade = new Cargo();
		
	}

	@Override
	protected long getEntidadeId(Cargo c) {
		
		return c.getId();
	}

}
