package br.farn.folhacomercial.eco.negocioimpl;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.EventoDaoImpl;
import br.farn.folhacomercial.eco.dominio.Evento;
import br.farn.folhacomercial.eco.dominio.FolhaPagamento;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.negocio.ControllerEvento;

@ManagedBean
@Component
@Scope ("session")
public class ControllerEventoImpl extends AbstractController<Evento> implements ControllerEvento{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerEventoImpl (){
		super();
		instanciarEntidade();
		
	}

	@Inject
	private EventoDaoImpl dao;
	
	@Inject
	private HibernateTemplate ht;
	
	
	public Evento buscarPorId(Evento entidade) {
		return dao.findById(entidade.getId());
	}
	
	
	@Override
	protected void instanciarEntidade() {
		entidade = new Evento();
		entidade.setFolhaPagamento(new FolhaPagamento());
		entidade.setFuncionario(new Funcionario());
	}

	@Override
	protected long getEntidadeId(Evento ev) {
		return ev.getId();
	}


}
