package br.farn.folhacomercial.eco.view;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.farn.folhacomercial.eco.dominio.Empresa;
import br.farn.folhacomercial.eco.dominio.Evento;
import br.farn.folhacomercial.eco.dominio.FolhaPagamento;
import br.farn.folhacomercial.eco.dominio.Funcionario;
import br.farn.folhacomercial.eco.dominio.VendaFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerEvento;
import br.farn.folhacomercial.eco.negocio.ControllerFolhaPagamento;
import br.farn.folhacomercial.eco.negocio.ControllerFuncionario;
import br.farn.folhacomercial.eco.negocio.ControllerVendaFuncionario;

@Component
@Scope("session")
public class FolhaPagamentoBean extends AbstractCrudMBean<FolhaPagamento>{

	private int empresaSelecionada;	
	private Date mesCompetencia;
	private ListDataModel<Evento> listEvento;
	private ListDataModel<VendaDTO> vendasFuncEventos;
	
	
	
	public FolhaPagamentoBean (){
		super();
		limparFormulario();
	}
	
	@Inject
    private ControllerFolhaPagamento controller;
	
	@Inject
    private ControllerVendaFuncionario controllerVF;
	
	@Inject
    private ControllerFuncionario controllerFuncionario;
	
	@Inject
    private ControllerEvento controllerEV;
	
	@Override
	protected void limparFormulario() {
		 entidade = new FolhaPagamento();
		 entidade.setEmpresaFolha(new Empresa());
	}

	public ListDataModel<FolhaPagamento> getDataModel() {
		dataModel = new ListDataModel<FolhaPagamento>(controller.buscarTodos());
		return dataModel;
	}

	public ListDataModel<Evento> getDataModelEvento() {
		
		ArrayList<Evento> listaEventos = new ArrayList<Evento>();
		
		if(getEmpresaSelecionada()!=0 && getMesCompetencia()!=null){
			if(!getListFuncionarios().isEmpty() && getMesCompetencia()!=null){
				for (VendaDTO venda : getListVendasEventos()) {
					Evento evento = new Evento();
					evento.setFuncionario(new Funcionario());
					evento.setFuncionario(controllerFuncionario.buscarFuncionario(venda.getIdFuncionario())); 
					VendaDTO vendaDTO1 = controllerVF.buscarQuinzena(getEmpresaSelecionada(), venda.getIdFuncionario(), getMesCompetencia());
					VendaDTO vendaDTO2 = controllerVF.buscarQuinzena2(getEmpresaSelecionada(), venda.getIdFuncionario(), getMesCompetencia());
					evento.setValorComissao1q(vendaDTO1.getValorTotalVenda());
					evento.setValorComissao2q(vendaDTO2.getValorTotalVenda());
					listaEventos.add(evento);
				}
				listEvento = new ListDataModel<Evento>(listaEventos);
				
				
			}
			return listEvento;
		
		}
		return null;
		
	}
	
	public String salvarFolhaPagamento() {
		entidade = new FolhaPagamento();
			for (Funcionario funcionario : getListFuncionarios()){
				
				entidade.setEmpresaFolha(funcionario.getEmpresa());
				entidade.setMesCompetencia(getMesCompetencia());
				//controller.salvar(entidade);
				Evento evento = new Evento();
			for (Evento folhaPagamento: listEvento) {  
				
				evento.setId(folhaPagamento.getId());
				evento.setFolhaPagamento(entidade);
				evento.setFuncionario(folhaPagamento.getFuncionario());			
				evento.setValorComissao1q(folhaPagamento.getValorComissao1q());
				evento.setValorComissao2q(folhaPagamento.getValorComissao2q());
				evento.setQuinquenio(folhaPagamento.getQuinquenio());
				evento.setSalarioFamilia(folhaPagamento.getSalarioFamilia());
				evento.setSalario(folhaPagamento.getSalario());
				evento.setComplemento(folhaPagamento.getComplemento());
				evento.setHorasExtras(folhaPagamento.getHorasExtras());
				evento.setDiferencaRetroativo(folhaPagamento.getDiferencaRetroativo());
				evento.setRendimentoEventual(folhaPagamento.getRendimentoEventual());
				evento.setAdiantamento(folhaPagamento.getAdiantamento());
				evento.setValeTransporte(folhaPagamento.getValeTransporte());
				evento.setInss(folhaPagamento.getInss());
				evento.setIrrf(folhaPagamento.getIrrf());
				evento.setSindicato(folhaPagamento.getSindicato());
				evento.setDescontoEventual(folhaPagamento.getDescontoEventual());
				controller.salvar(entidade);
				//controllerEV.salvar(evento);				
				evento = new Evento();	
				
			} 
			entidade = new FolhaPagamento();
			}
		 
		setEmpresaSelecionada(0);
		listEvento = new ListDataModel<Evento>();		
		return null;
	}
	
	
	public ArrayList<VendaDTO> getListVendasEventos() {
		  List<VendaDTO> vendaFuncionarios;
		   if(getEmpresaSelecionada() != 0 && getMesCompetencia() != null){  
			  vendaFuncionarios = controllerVF.buscarGroupFuncionarioEvento(getEmpresaSelecionada(), getMesCompetencia());			  
		      return  (ArrayList<VendaDTO>) vendaFuncionarios;
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
	
	public int getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(int empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public Date getMesCompetencia() {
		return mesCompetencia;
	}

	public void setMesCompetencia(Date mesCompetencia) {
		this.mesCompetencia = mesCompetencia;
	}

	public ListDataModel<Evento> getListEvento() {
		return listEvento;
	}

	public void setListEvento(ListDataModel<Evento> listEvento) {
		this.listEvento = listEvento;
	}
	
				
	
}
