package br.farn.folhacomercial.eco.negocioimpl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.FuncionarioDaoImpl;
import br.farn.folhacomercial.eco.dominio.Cargo;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.negocio.ControllerFuncionario;

@ManagedBean
@Component
@Scope ("session")
public class ControllerFuncionarioImpl extends AbstractController<Funcionario> implements ControllerFuncionario{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerFuncionarioImpl (){		
		super();
		instanciarEntidade();
	}
	
	@Inject
	private FuncionarioDaoImpl dao;
	

	public Funcionario buscarPorId(Funcionario entidade) {
		return dao.findById(entidade.getId());
	}

	@Override
	protected void instanciarEntidade() {
		entidade = new Funcionario ();
		entidade.setCargo(new Cargo());
		entidade.setEmpresa(new Empresa());
		
	}

	@Override
	protected long getEntidadeId(Funcionario f) {
		return f.getId();
	}

	public List<Funcionario> buscarPorEmpresa1(Funcionario entidade) {
		  lista = (List<Funcionario>) dao.buscarPorEmpresa(entidade.getEmpresa().getId());
	        return lista;		
	}

	@Override
	public List<Funcionario> buscarPorEmpresa(int id) {
		  lista = (List<Funcionario>) dao.buscarPorEmpresa(id);
	        return lista;	
	}

	@Override
	public Funcionario buscarFuncionario(int id) {
        return dao.buscarFuncionario(id);	
	}

}
