package br.farn.folhacomercial.eco.dadosimpl;


import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import br.farn.folhacomercial.eco.dados.FuncionarioDao;
import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;


@Component ("FuncionarioDao")
public class FuncionarioDaoImpl extends AbstractDao<Funcionario> implements	FuncionarioDao {

	public FuncionarioDaoImpl() {
		super();
	}

	@Inject
	private HibernateTemplate ht;
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarPorEmpresa(int empresa) {
		
		return ht.find("from Funcionario f where f.empresa.id = ?", empresa);
	}
	public Funcionario buscarFuncionario(int id) {
		return ht.get(Funcionario.class, id);
	}
	
}
