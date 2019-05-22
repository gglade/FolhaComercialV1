package br.farn.folhacomercial.eco.negocio;

import java.util.Date;
import java.util.List;

import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.view.VendaDTO;

public interface ControllerVendaFuncionario {

	public void salvar(VendaFuncionario vendaFuncionario);

	public void remover(VendaFuncionario vendaFuncionario);

	public void editar(VendaFuncionario vendaFuncionario);

	public List<VendaFuncionario> buscarTodos();

	public VendaFuncionario buscarPorId(VendaFuncionario entidade);
	
	public List<VendaFuncionario> buscarPorEmpresa(int idEmpresa, Date data);
	
	public List<VendaFuncionario> buscarPorEmpresa2(int idEmpresa, Date data1, Date data2);
	
	public List<VendaFuncionario> buscarPorEmpresaGroupValor(int idEmpresa, Date data1, Date data2);
	
	public List <VendaDTO> buscarGroupValor(int idEmpresa, Date data1, Date data2);
	
	public List <VendaDTO> buscarGroupFuncionarioEvento(int idEmpresa, Date data1);
	
	public VendaDTO buscarQuinzena(int idEmpresa,int idFuncionario, Date data1);
	
	public VendaDTO buscarQuinzena2(int idEmpresa ,int idFuncionario, Date data1);

}
