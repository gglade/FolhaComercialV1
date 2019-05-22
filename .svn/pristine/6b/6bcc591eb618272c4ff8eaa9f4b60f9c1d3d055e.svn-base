package br.farn.folhacomercial.eco.dadosimpl;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dados.EventoDao;
import br.farn.folhacomercial.eco.dominio.Evento;


@Component ("EventoDao")
public class EventoDaoImpl extends AbstractDao<Evento> implements EventoDao{
	
	public EventoDaoImpl (){
		super();
	}

	@Inject
	private HibernateTemplate ht;

}
