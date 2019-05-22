package br.farn.folhacomercial.eco.negocioimpl;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.FolhaPagamentoDaoImpl;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.FolhaPagamento;
import br.farn.folhacomercial.eco.negocio.ControllerFolhaPagamento;

@ManagedBean
@Component
@Scope ("session")
public class ControllerFolhaPagamentoImpl extends AbstractController<FolhaPagamento> implements ControllerFolhaPagamento{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerFolhaPagamentoImpl (){
		super();
		instanciarEntidade();
		
	}

	@Inject
	private FolhaPagamentoDaoImpl dao;
	
	@Inject
	private HibernateTemplate ht;
	
	
	public FolhaPagamento buscarPorId(FolhaPagamento entidade) {
		return dao.findById(entidade.getId());
	}
	
	
	@Override
	protected void instanciarEntidade() {
		entidade = new FolhaPagamento();
		entidade.setEmpresaFolha(new Empresa());
	}

	@Override
	protected long getEntidadeId(FolhaPagamento vf) {
		return vf.getId();
	}






}
