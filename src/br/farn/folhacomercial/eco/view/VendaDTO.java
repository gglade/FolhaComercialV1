package br.farn.folhacomercial.eco.view;

import org.springframework.stereotype.Component;

@Component
public class VendaDTO {
	
	//private Date dataProcessamento;	
	private String nome;
	private String descricao;
	private double valorTotalVenda;
	private int idFuncionario;
	
	
	public VendaDTO(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	
}
