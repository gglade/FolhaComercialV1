package br.farn.folhacomercial.eco.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sequence_evento", name = "SEQ", allocationSize = 1)
	@Column(name = "idevento")
	private int id;

	
	@ManyToOne
	@JoinColumn(name = "idfolhapagamento")
	private FolhaPagamento folhaPagamento;

	@ManyToOne
	@JoinColumn(name = "idfuncionario")
	private Funcionario funcionario;

	
	@Column(name = "valor_comissao_1q", nullable = false, length = 12, insertable = true, updatable = true)
	private double valorComissao1q;
	
	@Column(name = "valor_comissao_2q", nullable = false, length = 12, insertable = true, updatable = true)
	private double valorComissao2q;
	
	@Column(name = "quinquenio",  length = 12, insertable = true, updatable = true)
	private double quinquenio;
	
	@Column(name = "salario_familia",  length = 12, insertable = true, updatable = true)
	private double salarioFamilia;
	
	@Column(name = "salario",  length = 12, insertable = true, updatable = true)
	private double salario;
	
	@Column(name = "complemento", length = 12, insertable = true, updatable = true)
	private double complemento;
	
	@Column(name = "horas_extras", length = 12, insertable = true, updatable = true)
	private double horasExtras;
	
	@Column(name = "diferenca_retroativo", length = 12, insertable = true, updatable = true)
	private double diferencaRetroativo;
	
	@Column(name = "adiantamento", length = 12, insertable = true, updatable = true)
	private double adiantamento;
	
	@Column(name = "vale_transporte", length = 12, insertable = true, updatable = true)
	private double valeTransporte;
	
	@Column(name = "inss", length = 12, insertable = true, updatable = true)
	private double inss;

	@Column(name = "irrf", length = 12, insertable = true, updatable = true)
	private double irrf;
		
	@Column(name = "sindicato", length = 12, insertable = true, updatable = true)
	private double sindicato;

	@Column(name = "descontoEventual", length = 12, insertable = true, updatable = true)
	private double descontoEventual;
	
	@Column(name = "rendimentoEventual", length = 12, insertable = true, updatable = true)
	private double rendimentoEventual;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}


	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}


	public double getValorComissao1q() {
		return valorComissao1q;
	}


	public void setValorComissao1q(double valorComissao1q) {
		this.valorComissao1q = valorComissao1q;
	}


	public double getValorComissao2q() {
		return valorComissao2q;
	}


	public void setValorComissao2q(double valorComissao2q) {
		this.valorComissao2q = valorComissao2q;
	}


	public double getQuinquenio() {
		return quinquenio;
	}


	public void setQuinquenio(double quinquenio) {
		this.quinquenio = quinquenio;
	}


	public double getSalarioFamilia() {
		return salarioFamilia;
	}


	public void setSalarioFamilia(double salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public double getComplemento() {
		return complemento;
	}


	public void setComplemento(double complemento) {
		this.complemento = complemento;
	}


	public double getHorasExtras() {
		return horasExtras;
	}


	public void setHorasExtras(double horasExtras) {
		this.horasExtras = horasExtras;
	}


	public double getDiferencaRetroativo() {
		return diferencaRetroativo;
	}


	public void setDiferencaRetroativo(double diferencaRetroativo) {
		this.diferencaRetroativo = diferencaRetroativo;
	}


	public double getAdiantamento() {
		return adiantamento;
	}


	public void setAdiantamento(double adiantamento) {
		this.adiantamento = adiantamento;
	}


	public double getValeTransporte() {
		return valeTransporte;
	}


	public void setValeTransporte(double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}


	public double getInss() {
		return inss;
	}


	public void setInss(double inss) {
		this.inss = inss;
	}


	public double getIrrf() {
		return irrf;
	}


	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}


	public double getSindicato() {
		return sindicato;
	}


	public void setSindicato(double sindicato) {
		this.sindicato = sindicato;
	}


	public double getDescontoEventual() {
		return descontoEventual;
	}


	public void setDescontoEventual(double descontoEventual) {
		this.descontoEventual = descontoEventual;
	}


	public double getRendimentoEventual() {
		return rendimentoEventual;
	}


	public void setRendimentoEventual(double rendimentoEventual) {
		this.rendimentoEventual = rendimentoEventual;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	

	
}
