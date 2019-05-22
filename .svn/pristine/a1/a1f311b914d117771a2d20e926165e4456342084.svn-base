package br.farn.folhacomercial.eco.negocioimpl;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.EmpresaDaoImpl;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.negocio.ControllerEmpresa;

@ManagedBean
@Component
@Scope ("session")
public class ControllerEmpresaImpl extends AbstractController<Empresa> implements ControllerEmpresa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerEmpresaImpl (){
		super();
		instanciarEntidade();
	}	
	
	@Inject
	private EmpresaDaoImpl dao;

	public Empresa buscarPorId(Empresa entidade) {
		 return dao.findById(entidade.getId());
	}

	@Override
	protected void instanciarEntidade() {
		entidade = new Empresa();
	}


	@Override
	protected long getEntidadeId(Empresa e) {
		return e.getId();
	}

}
