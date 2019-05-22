package br.farn.folhacomercial.eco.negocio;

import java.util.List;

import br.farn.folhacomercial.eco.dominio.Empresa;


public interface ControllerEmpresa {
	
	
	public void salvar(Empresa empresa);

	public void remover(Empresa empresa);

	public void editar(Empresa empresa);

	public List<Empresa> buscarTodos();

	public Empresa buscarPorId(Empresa entidade);

}
