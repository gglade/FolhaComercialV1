package br.farn.folhacomercial.eco.dominio;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cargo {

	@Id
	@Column(name = "IdCargo")
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
	private int id;
	@Column(name = "Descricao", length = 40, insertable = true, updatable = true)
	private String descricao;
	@Column(name = "Situcao", nullable = false, length = 1, insertable = true, updatable = true)
	private String situacao;

	/* RELACIONAMENTO DE UM CARGO PARA MUITOS FUNCIONARIOS */
	@OneToMany(mappedBy = "cargo")
	private Collection<Funcionario> funcionarios;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
	
}
