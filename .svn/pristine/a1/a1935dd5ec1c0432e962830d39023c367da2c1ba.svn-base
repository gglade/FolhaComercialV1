package br.farn.folhacomercial.eco.dominio;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
public class Funcionario {

	@Id
	@Column(name = "IdFuncionario")
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
	private int id;
	@Column(name = "Nome", nullable = false, length = 40, insertable = true, updatable = true)
	private String nome;
	@Column(name = "CPF", nullable = false, length = 15, insertable = true, updatable = true)
	private String cpf;
	@Column(name = "Situcao", nullable = false, length = 1, insertable = true, updatable = true)
	private String situacao;

	/* RELACIONAMENTO DE UM OU MAIS FUNCIONARIO UM PARA CARGO */
	@ManyToOne
	@JoinColumn(name = "IdCargo", nullable = false)
	private Cargo cargo;

	/* RELACIONAMENTO DE UM OU MAIS FUNCIONARIO PARA UMA EMPRESA */
	@ManyToOne
	@JoinColumn(name = "IdEmpresa")
	private Empresa empresa;

	/* RELACIONAMENTO DE UM FUNCIONARIO PARA MUITA VENDAS */
	@OneToMany(mappedBy = "funcionario")
	private Collection<VendaFuncionario> vendafuncionarios;
	
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<VendaFuncionario> getVendafuncionarios() {
		return vendafuncionarios;
	}

	public void setVendafuncionarios(
			Collection<VendaFuncionario> vendafuncionarios) {
		this.vendafuncionarios = vendafuncionarios;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
