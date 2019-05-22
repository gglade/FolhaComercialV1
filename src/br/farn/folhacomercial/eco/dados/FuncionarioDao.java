package br.farn.folhacomercial.eco.dados;

import java.util.List;

import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;



public interface FuncionarioDao {
	
	
	public void salvar(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public void editar(Funcionario funcionario);

	public List<Funcionario> buscarTodos();
	
	public List<Funcionario> buscarPorEmpresa (int empresa);
	
	public Funcionario buscarFuncionario (int id);
	
	Funcionario findById(long id);

}
