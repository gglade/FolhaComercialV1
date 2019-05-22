package br.farn.folhacomercial.eco.dados;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.view.VendaDTO;

public interface VendaFuncionarioDao {

	public void salvar(VendaFuncionario vendaFuncionario);

	public void remover(VendaFuncionario vendaFuncionario);

	public void editar(VendaFuncionario vendaFuncionario);

	public List<VendaFuncionario> buscarTodos();

	VendaFuncionario findById(long id);
	
	public List<VendaFuncionario> buscarPorEmpresa2(int empresa, Date data1, Date data2);
	
	public Collection<VendaFuncionario> buscarPorEmpresaGroupValor(int empresa, Date data1, Date data2);
	
	public List<VendaDTO> buscarGroupValor(int empresa, Date data1, Date data2);
	
	public List<VendaDTO> buscarGroupFuncionarioEvento(int empresa , Date data1);
	
	public VendaDTO buscarQuinzena(int empresa ,int idFuncionario, Date data1);
	
	public VendaDTO buscarQuinzena2(int empresa ,int idFuncionario, Date data1);
	
}
