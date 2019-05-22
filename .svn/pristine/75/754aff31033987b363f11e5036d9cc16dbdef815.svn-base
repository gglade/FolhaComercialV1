package br.farn.folhacomercial.eco.negocioimpl;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dadosimpl.VendaFuncionarioDaoImpl;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerVendaFuncionario;
import br.farn.folhacomercial.eco.view.CalendarUtils;
import br.farn.folhacomercial.eco.view.VendaDTO;

@ManagedBean
@Component
@Scope ("session")
public class ControllerVendaFuncionarioImpl extends AbstractController<VendaFuncionario> implements ControllerVendaFuncionario{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerVendaFuncionarioImpl (){
		super();
		instanciarEntidade();
		
	}

	@Inject
	private VendaFuncionarioDaoImpl dao;
	
	@Inject
	private HibernateTemplate ht;
	
	
	public VendaFuncionario buscarPorId(VendaFuncionario entidade) {
		return dao.findById(entidade.getId());
	}
	
	@Override
	public List<VendaFuncionario> buscarPorEmpresa2(int idEmpresa, Date data1, Date data2) {
		lista = (List<VendaFuncionario>) dao.buscarPorEmpresa2(idEmpresa, data1, data2);
	        return lista;
	}
	
	@Override
	public List<VendaFuncionario> buscarPorEmpresaGroupValor(int idEmpresa,
			Date data1, Date data2) {
		lista = (List<VendaFuncionario>) dao.buscarPorEmpresaGroupValor(idEmpresa, data1, data2);
        return lista;
	}

	@Override
	public List<VendaDTO> buscarGroupValor(int idEmpresa, Date data1, Date data2) {
		 List<VendaDTO> lista = (List<VendaDTO>) dao.buscarGroupValor(idEmpresa, data1, data2);
        return lista;
	}

	
	@SuppressWarnings("unchecked")
	public List<VendaFuncionario> buscarPorEmpresa(int empresa, Date data) {
				
		return ht.find("from VendaFuncionario vf where vf.empresa.id = ? and dataVenda = ?", empresa, data);
	}
	
	
	@Override
	protected void instanciarEntidade() {
		entidade = new VendaFuncionario();
		entidade.setEmpresa(new Empresa());
		entidade.setFuncionario(new Funcionario());
	}

	@Override
	protected long getEntidadeId(VendaFuncionario vf) {
		return vf.getId();
	}

	@Override
	public List<VendaDTO> buscarGroupFuncionarioEvento(int idEmpresa, Date data1) {
		 List<VendaDTO> lista = (List<VendaDTO>) dao.buscarGroupFuncionarioEvento(idEmpresa, data1);
         return lista;
	}

	@Override
	public VendaDTO buscarQuinzena(int idEmpresa, int idFuncionario,
			Date data1) {
		VendaDTO quinzena = dao.buscarQuinzena(idEmpresa, idFuncionario, data1);
		return quinzena;
	}

	@Override
	public VendaDTO buscarQuinzena2(int idEmpresa, int idFuncionario, Date data1) {
		VendaDTO quinzena2 = dao.buscarQuinzena2(idEmpresa, idFuncionario, data1);
		return quinzena2;
	}



}
