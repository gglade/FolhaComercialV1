package br.farn.folhacomercial.eco.dominio;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class MetaEmpresa {

	@Id
	@Column(name = "IdMetaEmpresa")
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
	private int id;
	@Column(name = "ValorMeta", nullable = false, length = 50, insertable = true, updatable = true)
	private double valorEmpresa = 0d;
	@Column(nullable = false, length = 4, insertable = true, updatable = true)
	private double qtdeFuncionario;
	@Column(name = "Percentual", nullable = false, length = 4, insertable = true, updatable = true)
	private double percentual;
	@Temporal(TemporalType.DATE)
	@Column(name = "DataMeta", nullable = false, length = 15, insertable = true, updatable = true)
	private Date dataMeta;
	
//	@Transient
//	private double valorVendedor = valorEmpresa / qtdeFuncionario;
	//perguntar ou criar um metodo para fazer esse calculo
	
	@Transient
	private double valorEmpresa3;
	@Transient
	private double valorEmpresa2;
	@Transient
	private double valorEmpresa1;

	/* RELACIONAMENTO DE UMA OU MAIS METAS PARA UMA EMPRESA */
	@ManyToOne
	@JoinColumn(name = "IdEmpresa")
	private Empresa empresa;
		
	
	public Double getValorVendedor() {
		//return valorEmpresa != null ? valorEmpresa / qtdeFuncionario : null;
		return valorEmpresa / qtdeFuncionario ;
	}
		
	public double getValorVendedor3(){
	return getValorEmpresa3() / qtdeFuncionario;	
	}

	public double getValorVendedor2(){
		return getValorEmpresa2() / qtdeFuncionario;	
		}
	
	public double getValorVendedor1(){
		return getValorEmpresa1() / qtdeFuncionario;	
		}
	

	public Date getDataMeta() {
		return dataMeta;
	}

	public void setDataMeta(Date dataMeta) {
		this.dataMeta = dataMeta;
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

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public double getQtdeFuncionario() {
		return qtdeFuncionario;
	}

	public void setQtdeFuncionario(double qtdeFuncionario) {
		this.qtdeFuncionario = qtdeFuncionario;
	}

	public double getValorEmpresa() {
		return valorEmpresa;
	}

	public void setValorEmpresa(double valorEmpresa) {
		this.valorEmpresa = valorEmpresa;
	}

	public double getValorEmpresa1() {
		return getValorEmpresa2() * 0.95;
	}

	public void setValorEmpresa1(double valorEmpresa1) {
		this.valorEmpresa1 = valorEmpresa1;
	}

	public double getValorEmpresa2() {
		return getValorEmpresa3() * 0.95;
	}

	public void setValorEmpresa2(double valorEmpresa2) {
		this.valorEmpresa2 = valorEmpresa2;
	}

	public double getValorEmpresa3() {
		return valorEmpresa * 0.93;
	}

	public void setValorEmpresa3(double valorEmpresa3) {
		this.valorEmpresa3 = valorEmpresa3;
	}

	//calculo 1 quinzena
	public double primeiraQuinzena(){
		return valorEmpresa*percentual;
	}
	//caluclo 2 quinzena
	public double segundaQuizena(){
		return valorEmpresa-primeiraQuinzena();
	}

	// transiente valor vendedor
//	public double getValorVendedor() {
//		return valorVendedor;
//	}

//	public void setValorVendedor(double valorVendedor) {
//		this.valorVendedor = valorVendedor;
//	}
	
		
}
