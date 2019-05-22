package br.farn.folhacomercial.eco.dadosimpl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dados.MetaEmpresaDao;
import br.farn.folhacomercial.eco.dominio.MetaEmpresa;
import br.farn.folhacomercial.eco.view.CalendarUtils;

@Component ("MetaEmpresaDao")
public class MetaEmpresaDaoImpl extends AbstractDao<MetaEmpresa> implements MetaEmpresaDao{
	
	public MetaEmpresaDaoImpl (){
		super();
	}

	@Inject
	private HibernateTemplate ht;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MetaEmpresa> buscarPorEmpresa(int empresa, Date data1,Date data2) {

		Date dataInicio = CalendarUtils.descartarHoras(data1);
		Date dataFim = CalendarUtils.incluirHoraFimDia(data2);
		return ht.find("from MetaEmpresa me where me.empresa.id = ? and dataMeta between ? and ?", empresa, dataInicio, dataFim);
		
	}

}
