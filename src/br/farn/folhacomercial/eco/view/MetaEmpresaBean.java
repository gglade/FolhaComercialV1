package br.farn.folhacomercial.eco.view;


import java.util.Date;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.MetaEmpresa;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerMetaEmpresa;

@Component
@Scope("session")
public class MetaEmpresaBean extends AbstractCrudMBean<MetaEmpresa>{

	private List<MetaEmpresa> metaEmpresas;
	private ListDataModel<MetaEmpresa> dataModelMetaEmpresa;	
	private Date dataVenda1;
	private Date dataVenda2;
	private int empresaSelecionada;
		
	public MetaEmpresaBean (){
		super();
		limparFormulario();
		
	}
	
	@Inject
    private ControllerMetaEmpresa controller;
	
	
	@Override
	protected void limparFormulario() {
		 entidade = new MetaEmpresa();
		 entidade.setEmpresa(new Empresa());		
	}	

	
	public ListDataModel<MetaEmpresa> getDataModel() {
		dataModel = new ListDataModel<MetaEmpresa>(controller.buscarTodos());
		return dataModel;
	}
	
	public void carregarRegistros(){
		this.dataModelMetaEmpresa = getListDataModel();
	}
	
	public ListDataModel<MetaEmpresa> getListDataModel() {
		  List<MetaEmpresa> metaEmpresas;
		   if(empresaSelecionada != 0 && dataVenda1 != null && dataVenda2 != null){  
			  metaEmpresas = controller.buscarPorEmpresa(getEmpresaSelecionada(), getDataVenda1(), getDataVenda2());
		      dataModelMetaEmpresa = new ListDataModel<MetaEmpresa>(metaEmpresas) ;
		      return  dataModelMetaEmpresa;
		   }  
		   return null;
	}
			
	
	
	
	
	public String prepararAlterar() {
		// limparFormulario();
		entidade = dataModel.getRowData();
		return null;
	}


	public List<MetaEmpresa> getMetaEmpresas() {
		this.metaEmpresas = controller.buscarTodos();
		return metaEmpresas;
	}


	public void setMetaEmpresas(List<MetaEmpresa> metaEmpresas) {
		this.metaEmpresas = metaEmpresas;
	}


	public double getPrimeiraQuinzena(){
		return (entidade.getValorEmpresa() * entidade.getPercentual()) / 100;
	}
	
	public double getValorQuinzenaVendedor(){
		return getPrimeiraQuinzena() / entidade.getQtdeFuncionario();		
	}	

	public double getPrimeiraQuinzena3(){
		return getPrimeiraQuinzena() * 0.93;
	}
	
	public double getValorQuinzenaVendedor3(){
		return getPrimeiraQuinzena3() / entidade.getQtdeFuncionario();		
	}
	
	public double getPrimeiraQuinzena2(){
		return getPrimeiraQuinzena3() * 0.95;
	}
	
	public double getValorQuinzenaVendedor2(){
		return getPrimeiraQuinzena2() / entidade.getQtdeFuncionario();		
	}
	
	public double getPrimeiraQuinzena1(){
		return getPrimeiraQuinzena2() * 0.95;
	}
	
	public double getValorQuinzenaVendedor1(){
		return getPrimeiraQuinzena1() / entidade.getQtdeFuncionario();		
	}
	
//####################
	
	public double getSegundaQuinzena(){
		return entidade.getValorEmpresa() - getPrimeiraQuinzena();
	}
	
	public double getSegundaQuinzenaVendedor(){
		return getSegundaQuinzena() / entidade.getQtdeFuncionario();		
	}
	
	public double getSegundaQuinzena3(){
		return getSegundaQuinzena() * 0.93;
	}
	
	public double getSegundaQuinzenaVendedor3(){
		return getSegundaQuinzena3() / entidade.getQtdeFuncionario();
	}
	
	public double getSegundaQuinzena2(){
		return getSegundaQuinzena3() * 0.95;
	}
	
	public double getSegundaQuinzenaVendedor2(){
		return getSegundaQuinzena2() / entidade.getQtdeFuncionario();
	}
	
	public double getSegundaQuinzena1(){
		return getSegundaQuinzena2() * 0.95;
	}
	
	public double getSegundaQuinzenaVendedor1(){
		return getSegundaQuinzena1() / entidade.getQtdeFuncionario();
	}

///********************************************************************novo
	public ListDataModel<MetaEmpresa> getDataModelMetaEmpresa() {
		return dataModelMetaEmpresa;
	}


	public void setDataModelMetaEmpresa(
			ListDataModel<MetaEmpresa> dataModelMetaEmpresa) {
		this.dataModelMetaEmpresa = dataModelMetaEmpresa;
	}


	public Date getDataVenda1() {
		return dataVenda1;
	}


	public void setDataVenda1(Date dataVenda1) {
		this.dataVenda1 = dataVenda1;
	}


	public Date getDataVenda2() {
		return dataVenda2;
	}


	public void setDataVenda2(Date dataVenda2) {
		this.dataVenda2 = dataVenda2;
	}


	public int getEmpresaSelecionada() {
		return empresaSelecionada;
	}


	public void setEmpresaSelecionada(int empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	
	
}
