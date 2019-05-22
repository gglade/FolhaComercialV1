package br.farn.folhacomercial.eco.dados;

import java.util.List;

import br.farn.folhacomercial.eco.dominio.FolhaPagamento;

public interface FolhaPagamentoDao {

	public void salvar(FolhaPagamento folhaPagamento);

	public void remover(FolhaPagamento folhaPagamento);

	public void editar(FolhaPagamento folhaPagamento);

	public List<FolhaPagamento> buscarTodos();

	FolhaPagamento findById(long id);
	
	

}
