package br.farn.folhacomercial.eco.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerVendaFuncionario;

@Component
@Scope("session")
public class VendaFuncionarioBean extends AbstractCrudMBean<VendaFuncionario>{

	private List<VendaFuncionario> vendafuncionarios;	
	private ListDataModel<VendaFuncionario> dataModelVenda;
	private ListDataModel<VendaDTO> vendasAgrupada;	
	private Empresa empresa;	
	private Date dataVenda1;
	private Date dataVenda2;
	private Date dataVenda;
	private int empresaSelecionada;
	private ListDataModel<Funcionario> listCodFunc;
	
	
	public VendaFuncionarioBean (){
		super();
		empresa = new Empresa();
		limparFormulario();
	}
	
	@Inject
    private ControllerVendaFuncionario controller;
	
	@Inject
    private ControllerFuncionario controllerFuncionario;
	
	
	@Override
	protected void limparFormulario() {
		 entidade = new VendaFuncionario();
		 entidade.setFuncionario(new Funcionario());
		 entidade.setEmpresa(new Empresa());
		// entidade.setmetaEmpresa(new MetaEmpresa());			
	}

	public ListDataModel<VendaFuncionario> getDataModel() {
		dataModel = new ListDataModel<VendaFuncionario>(controller.buscarTodos());
		return dataModel;
	}
	

	
	
	public ListDataModel<VendaFuncionario> getDataModelVenda() {
		
		ArrayList<VendaFuncionario> listaVendaFuncionario = new ArrayList<VendaFuncionario>();
		
		if(getEmpresaSelecionada()!=0 && dataVenda != null){
			
		listaVendaFuncionario = (ArrayList<VendaFuncionario>) controller.buscarPorEmpresa(getEmpresaSelecionada(), getDataVenda());
		
		if(!listaVendaFuncionario.isEmpty() && listaVendaFuncionario.size()!=getListCodFunc().getRowCount()){
			int dif = listaVendaFuncionario.size();
			for(int i = dif; i < getListFuncionarios().size();i++){
				VendaFuncionario vf = new VendaFuncionario();
				vf.setFuncionario(new Funcionario());
				
				vf.setEmpresa(getListFuncionarios().get(i).getEmpresa());
				vf.getFuncionario().setNome(getListFuncionarios().get(i).getNome());
				vf.getFuncionario().setCargo(getListFuncionarios().get(i).getCargo());
				vf.getFuncionario().setCpf(getListFuncionarios().get(i).getCpf());
				vf.getFuncionario().setId(getListFuncionarios().get(i).getId());
				vf.getFuncionario().setSituacao(getListFuncionarios().get(i).getSituacao());
				vf.setDataVenda(getDataVenda());
				listaVendaFuncionario.add(vf);
			}
		}
		if(listaVendaFuncionario.isEmpty())	
		for (Funcionario funcionario : getListCodFunc()) {
			VendaFuncionario vendaFuncionario = new VendaFuncionario();
			vendaFuncionario.setEmpresa(funcionario.getEmpresa());
			vendaFuncionario.setFuncionario(funcionario);
			vendaFuncionario.setDataVenda(getDataVenda());
			listaVendaFuncionario.add(vendaFuncionario);
		}

		dataModelVenda = new ListDataModel<VendaFuncionario>(listaVendaFuncionario);
		return dataModelVenda;
		
		}
		return null;
		
	}

	public void carregarRegistros(){
		this.dataModelVenda = getListDataModel2();
	}
	
	public ListDataModel<VendaFuncionario> getListDataModel2() {
		  List<VendaFuncionario> vendaFuncionarios;
		   if(empresaSelecionada != 0 && dataVenda1 != null && dataVenda2 != null){  
			  vendaFuncionarios = controller.buscarPorEmpresa2(getEmpresaSelecionada(), getDataVenda1(), getDataVenda2());
		      dataModelVenda = new ListDataModel<VendaFuncionario>(vendaFuncionarios) ;  
		      return  dataModelVenda;
		   }  
		   return null;
	}
	
	
	public void carregarRegistros4(){
		this.vendasAgrupada = getListDataModel4();
	}
	
	public ListDataModel<VendaDTO> getListDataModel4() {
		  List<VendaDTO> vendaFuncionarios;
		   if(empresaSelecionada != 0 && dataVenda1 != null && dataVenda2 != null){  
			  vendaFuncionarios = controller.buscarGroupValor(getEmpresaSelecionada(), getDataVenda1(), getDataVenda2());			  
			  vendasAgrupada = new ListDataModel<VendaDTO>(vendaFuncionarios) ;  
		      return  vendasAgrupada;
		   }  
		   return null;
	}
	
	public String salvarVendaFuncionario() {
		entidade = new VendaFuncionario();
		for (VendaFuncionario vendaFuncionario: dataModelVenda) {  
			entidade.setId(vendaFuncionario.getId());
	    	entidade.setFuncionario(vendaFuncionario.getFuncionario());
	    	entidade.setEmpresa(vendaFuncionario.getEmpresa());
	    	entidade.setValorTotalVenda(vendaFuncionario.getValorTotalVenda());
	    	entidade.setDataVenda(getDataVenda());
			controller.salvar(entidade);
			entidade = new VendaFuncionario();
		}  
		setEmpresaSelecionada(0);
		dataModelVenda = new ListDataModel<VendaFuncionario>();
		return null;
	}

	
	public List<VendaFuncionario> getVendafuncionarios() {
		this.vendafuncionarios = controller.buscarTodos();
		return vendafuncionarios;
	}

	public void setVendafuncionarios(List<VendaFuncionario> vendafuncionarios) {
		this.vendafuncionarios = vendafuncionarios;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setDataModelVenda(ListDataModel<VendaFuncionario> dataModelVenda) {
		this.dataModelVenda = dataModelVenda;
	}
	
	
	public int getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(int empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public void actionCarregarFuncionarios() {  
		   this.listCodFunc =  getListCodFunc();  
		}  

	public ListDataModel<Funcionario> getListCodFunc() {
		  List<Funcionario> funcionarios;
		   if(empresaSelecionada != 0 && dataVenda != null){  
			  funcionarios = controllerFuncionario.buscarPorEmpresa(getEmpresaSelecionada());
		      listCodFunc = new ListDataModel<Funcionario>(funcionarios) ;  
		      return  listCodFunc;
		   }  
		   return null;
	}	
		
	public List<Funcionario> getListFuncionarios() {
		  ArrayList<Funcionario> funcionarios;
		   if(empresaSelecionada != 0){  
			  funcionarios = (ArrayList<Funcionario>) controllerFuncionario.buscarPorEmpresa(getEmpresaSelecionada());
		      return  funcionarios;
		   }  
		   return null;
	}
	public void setListCodFunc(ListDataModel<Funcionario> listCodFunc) {
		this.listCodFunc = (ListDataModel<Funcionario>) listCodFunc;
	}

	public ControllerFuncionario getControllerFuncionario() {
		return controllerFuncionario;
	}

	public void setControllerFuncionario(ControllerFuncionario controllerFuncionario) {
		this.controllerFuncionario = controllerFuncionario;
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

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public ListDataModel<VendaDTO> getVendasAgrupada() {
		return vendasAgrupada;
	}

	public void setVendasAgrupada(ListDataModel<VendaDTO> vendasAgrupada) {
		this.vendasAgrupada = vendasAgrupada;
	}
				
	
}
