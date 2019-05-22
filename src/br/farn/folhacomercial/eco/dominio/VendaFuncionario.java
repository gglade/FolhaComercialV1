package br.farn.folhacomercial.eco.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class VendaFuncionario {
	
	
	/* objeto do tipo empresa */
	@Id
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
	@Column(name = "idvendafuncionario")
	private int id;
	
	@Transient
	private MetaEmpresa metaEmpresa;
	
	@Column(name = "vendafunc", nullable = false, length = 12, insertable = true, updatable = true)
	private double valorTotalVenda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datavenda", nullable = false, length = 15, insertable = true, updatable = true)
	private Date dataVenda;	
	
	@ManyToOne
	@JoinColumn(name = "idfuncionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "IdEmpresa")
	private Empresa empresa;	
		

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MetaEmpresa getmetaEmpresa() {
		return metaEmpresa;
	}

	public void setmetaEmpresa(MetaEmpresa metaEmpresa) {
		this.metaEmpresa = metaEmpresa;
	}
		
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public double getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}
//######################################################################################
	// CALCULOS
//######################################################################################	
	public double getMeta4() {
		return metaEmpresa.primeiraQuinzena() / metaEmpresa.getQtdeFuncionario();
	}

	public double getMeta3() {
		return getMeta4() * 0.93;
	}
	
	public double getMeta2() {
		return getMeta3() * 0.95;
	}

	public double getMeta1() {
		return getMeta2() * 0.95;
	}

	public double calculaSalario() {
		if (valorTotalVenda < getMeta2()) {
			return (valorTotalVenda / 100) * 3;
		} else if (valorTotalVenda >= getMeta2()
				&& valorTotalVenda < getMeta3()) {
			return (valorTotalVenda / 100) * 3.5;
		} else if (valorTotalVenda >= getMeta3()
				&& valorTotalVenda < getMeta4()) {
			return (valorTotalVenda / 100) * 4;
		} else if (valorTotalVenda >= getMeta4()) {
			return (valorTotalVenda / 100) * 4.5;
		}

		return 0;
	}
		
	

}
