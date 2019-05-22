package br.farn.folhacomercial.eco.dadosimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dados.VendaFuncionarioDao;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.view.CalendarUtils;
import br.farn.folhacomercial.eco.view.VendaDTO;

@Component ("VendaFuncionarioDao")
public class VendaFuncionarioDaoImpl extends AbstractDao<VendaFuncionario> implements VendaFuncionarioDao{
	
	public VendaFuncionarioDaoImpl (){
		super();
	}

	@Inject
	private HibernateTemplate ht;
	
	@SuppressWarnings("unchecked")
	public List<VendaFuncionario> buscarPorEmpresa2(int empresa, Date data1, Date data2) {
		Date dataInicio = CalendarUtils.descartarHoras(data1);
		Date dataFim = CalendarUtils.incluirHoraFimDia(data2);
		return ht.find("from VendaFuncionario vf where vf.empresa.id = ? and dataVenda between ? and ?", empresa, dataInicio, dataFim);
	}

	
	@SuppressWarnings({ "rawtypes" })
	public Collection<VendaFuncionario> buscarPorEmpresaGroupValor(int empresa, Date data1, Date data2) {
				
		
		Date dataInicio = CalendarUtils.descartarHoras(data1);
		Date dataFim = CalendarUtils.incluirHoraFimDia(data2);
		Query query = getSession().createQuery("select vf.empresa.descricao, " +
				"vf.funcionario.nome, " +				
				"sum(vf.valorTotalVenda) as valorTotal " +
				"from VendaFuncionario vf join vf.funcionario func join vf.empresa emp " +
				"where vf.empresa.id =:empresa  and dataVenda between :dataVenda and :dataVenda " +
				"group by vf.empresa.descricao, vf.funcionario.nome");
		query.setInteger("empresa", empresa);
		query.setDate("dataVenda", dataInicio);
		query.setDate("dataVenda", dataFim);
		
		ArrayList<VendaFuncionario> resultado = new ArrayList<VendaFuncionario>();
		Iterator it = query.list().iterator();		
		while (it.hasNext()){
			Object[] obj = (Object[]) it.next();
			VendaFuncionario vendafunc = new VendaFuncionario();
			vendafunc.setEmpresa((Empresa)obj[0]);
			vendafunc.setFuncionario((Funcionario)obj[1]);
			vendafunc.setValorTotalVenda((Double)obj[2]);
			resultado.add(vendafunc);
			
			//System.out.println(filme.getNome() + "\t" +filme.getAnoLancamento());
			}
		
		// return query.list();
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendaDTO> buscarGroupValor(int empresa, Date data1, Date data2) {
	
		List<VendaDTO> result = new ArrayList<VendaDTO>(); 
		
		Date dataInicio = CalendarUtils.descartarHoras(data1);
		Date dataFim = CalendarUtils.incluirHoraFimDia(data2);
		Query query = getSession().createQuery("select vf.empresa.descricao as descricao, " +
				"vf.funcionario.nome as nome, " +				
				"sum(vf.valorTotalVenda) as valorTotalVenda " +
				"from VendaFuncionario vf join vf.funcionario func join vf.empresa emp " +
				"where vf.empresa.id =:empresa  and dataVenda between :start and :end " +
				"group by vf.empresa.descricao, vf.funcionario.nome");
		query.setInteger("empresa", empresa);
		query.setDate("start", dataInicio);
		query.setDate("end", dataFim);
		
	query.setResultTransformer(new AliasToBeanResultTransformer(VendaDTO.class));
		
		result = (List<VendaDTO>) query.list();
		return  result; 
			   
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VendaDTO> buscarGroupFuncionarioEvento(int empresa ,Date data1) {
	
		List<VendaDTO> result = new ArrayList<VendaDTO>();
		
		Date dataFim = CalendarUtils.incluirHoraFimDia(data1);
		Date dataInicio = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFim);		
		
		if(cal.get(Calendar.DAY_OF_MONTH)==30 || cal.get(Calendar.DAY_OF_MONTH)==31){

		if(cal.get(Calendar.DAY_OF_MONTH)==30){
			dataInicio = CalendarUtils.somaDia(dataFim, -29);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}else {
			dataInicio = CalendarUtils.somaDia(dataFim, -30);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}
		
		}
		
		Query query = getSession().createQuery("select " +
				"vf.funcionario.id as idFuncionario, " +				
				"sum(vf.valorTotalVenda) as valorTotalVenda " +
				"from VendaFuncionario vf join vf.funcionario func join vf.empresa emp " +
				"where vf.empresa.id =:empresa  and dataVenda between :start and :end " +
				"group by vf.funcionario.id");
		query.setInteger("empresa", empresa);
		query.setDate("start", dataInicio);
		query.setDate("end", dataFim);
		
		query.setResultTransformer(new AliasToBeanResultTransformer(VendaDTO.class));
		
		result = (List<VendaDTO>) query.list();
		return  result; 
			   
	}


	@Override
	public VendaDTO buscarQuinzena(int empresa, int idFuncionario, Date data1) {
		
		Date dataFim = CalendarUtils.incluirHoraFimDia(data1);
		Date dataInicio = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFim);
		
		
		if(cal.get(Calendar.DAY_OF_MONTH)==30 || cal.get(Calendar.DAY_OF_MONTH)==31){

		if(cal.get(Calendar.DAY_OF_MONTH)==30){
			dataInicio = CalendarUtils.somaDia(dataFim, -29);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}else {
			dataInicio = CalendarUtils.somaDia(dataFim, -30);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}
		
		}
		dataFim = CalendarUtils.somaDia(dataFim, -15);
		
		Query query = getSession().createQuery("select " +
				"vf.funcionario.id as idFuncionario, " +				
				"sum(vf.valorTotalVenda) as valorTotalVenda " +
				"from VendaFuncionario vf join vf.funcionario func join vf.empresa emp " +
				"where vf.empresa.id =:empresa and vf.funcionario.id =:funcionario  and dataVenda between :start and :end " +
				"group by vf.funcionario.id");
		query.setInteger("empresa", empresa);
		query.setInteger("funcionario", idFuncionario);
		query.setDate("start", dataInicio);
		query.setDate("end", dataFim);
		
		query.setResultTransformer(new AliasToBeanResultTransformer(VendaDTO.class));
		System.out.println("Query :" + query.getQueryString() );
		VendaDTO result  = (VendaDTO) query.uniqueResult();
		return  result; 
	}


	@Override
	public VendaDTO buscarQuinzena2(int empresa, int idFuncionario, Date data1) {
		
		Date dataFim = CalendarUtils.descartarHoras(data1);
		Date dataInicio =  CalendarUtils.incluirHoraFimDia(data1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataFim);
		
		
		if(cal.get(Calendar.DAY_OF_MONTH)==30 || cal.get(Calendar.DAY_OF_MONTH)==31){

		if(cal.get(Calendar.DAY_OF_MONTH)==30){
			dataInicio = CalendarUtils.somaDia(dataFim, -29);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}else {
			dataInicio = CalendarUtils.somaDia(dataFim, -30);
			dataInicio = CalendarUtils.descartarHoras(dataInicio);
		}
		
		}
		dataInicio = CalendarUtils.somaDia(dataInicio, 15);
		
		Query query = getSession().createQuery("select " +
				"vf.funcionario.id as idFuncionario, " +				
				"sum(vf.valorTotalVenda) as valorTotalVenda " +
				"from VendaFuncionario vf join vf.funcionario func join vf.empresa emp " +
				"where vf.empresa.id =:empresa and vf.funcionario.id =:funcionario  and dataVenda between :start and :end " +
				"group by vf.funcionario.id");
		query.setInteger("empresa", empresa);
		query.setInteger("funcionario", idFuncionario);
		query.setDate("start", dataInicio);
		query.setDate("end", dataFim);
		
		query.setResultTransformer(new AliasToBeanResultTransformer(VendaDTO.class));
		System.out.println("Query :" + query.getQueryString() );
		VendaDTO result  = (VendaDTO) query.uniqueResult();
		return  result; 
		
	}

}
