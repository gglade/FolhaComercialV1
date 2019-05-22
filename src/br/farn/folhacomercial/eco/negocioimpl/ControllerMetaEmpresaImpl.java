package br.farn.folhacomercial.eco.negocioimpl;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.MetaEmpresaDaoImpl;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.MetaEmpresa;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerMetaEmpresa;

@ManagedBean
@Component
@Scope("session")
public class ControllerMetaEmpresaImpl extends AbstractController<MetaEmpresa>
		implements ControllerMetaEmpresa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerMetaEmpresaImpl() {
		super();
		instanciarEntidade();
	}

	@Inject
	private MetaEmpresaDaoImpl dao;

	public MetaEmpresa buscarPorId(MetaEmpresa entidade) {
		return dao.findById(entidade.getId());
	}

	@Override
	protected void instanciarEntidade() {
		entidade = new MetaEmpresa();
		entidade.setEmpresa(new Empresa());

	}

	@Override
	protected long getEntidadeId(MetaEmpresa me) {
		return me.getId();
	}

	@Override
	public List<MetaEmpresa> buscarPorEmpresa(int empresa, Date data1, Date data2) {
		lista=(List<MetaEmpresa>) dao.buscarPorEmpresa(empresa, data1, data2);
		return lista;
	}
}
