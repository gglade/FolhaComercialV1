package br.farn.folhacomercial.eco.dadosimpl;

import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dados.EmpresaDao;
import br.farn.folhacomercial.eco.dominio.Empresa;

@Component ("EmpresaDao")
public class EmpresaDaoImpl extends AbstractDao<Empresa> implements EmpresaDao {

	public EmpresaDaoImpl() {
		super();
	}

}
