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
public class Empresa {
	
	
	@Id
    @Column(name = "IdEmpresa")
    @GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
    private int id;
    @Column(name = "Descricao", nullable = false, length = 50, insertable = true, updatable = true)
    private String descricao;
    @Column(name = "Situcao", nullable = false, length = 1, insertable = true, updatable = true)
    private String situacao;
    
    
    /* RELACIONAMENTO DE UMA EMPRESA PARA MUITOS FUNCIONARIOS */
    @OneToMany(mappedBy = "empresa")
    private Collection<Funcionario> funcionarios;
	
    /* RELACIONAMENTO DE UMA EMPRESA PARA MUITAS METAS */
    @OneToMany(mappedBy = "empresa")
    private Collection<MetaEmpresa> metasempresas;
    
    
    @OneToMany(mappedBy = "empresa")
    private Collection<VendaFuncionario> vendasfuncionario;
    
    
    @OneToMany(mappedBy = "empresaFolha")
    private Collection<FolhaPagamento> folhaPagamentos;
    

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

    public Collection<MetaEmpresa> getMetasempresas() {
        return metasempresas;
    }

    public void setMetasempresas(Collection<MetaEmpresa> metasempresas) {
        this.metasempresas = metasempresas;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

	public Collection<VendaFuncionario> getVendasfuncionario() {
		return vendasfuncionario;
	}

	public void setVendasfuncionario(Collection<VendaFuncionario> vendasfuncionario) {
		this.vendasfuncionario = vendasfuncionario;
	}

	public Collection<FolhaPagamento> getFolhaPagamentos() {
		return folhaPagamentos;
	}

	public void setFolhaPagamentos(Collection<FolhaPagamento> folhaPagamentos) {
		this.folhaPagamentos = folhaPagamentos;
	}
    
}
