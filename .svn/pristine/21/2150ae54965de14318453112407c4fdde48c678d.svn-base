package br.farn.folhacomercial.eco.dados;

import java.util.Date;
import java.util.List;

import br.farn.folhacomercial.eco.dominio.MetaEmpresa;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;

public interface MetaEmpresaDao {

	public void salvar(MetaEmpresa metaEmpresa);

	public void remover(MetaEmpresa metaEmpresa);

	public void editar(MetaEmpresa metaEmpresa);

	public List<MetaEmpresa> buscarTodos();

	MetaEmpresa findById(long id);
	
	public List<MetaEmpresa> buscarPorEmpresa(int empresa, Date data1, Date data2);
}
