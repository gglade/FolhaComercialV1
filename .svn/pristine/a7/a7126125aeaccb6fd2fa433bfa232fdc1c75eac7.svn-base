package br.farn.folhacomercial.eco.dominio;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
public class FolhaPagamento {
	
	
	@Id
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sequence_folha", name = "SEQ", allocationSize = 1)
	@Column(name = "idfolhapagamento")
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "mescompetencia", nullable = false, length = 15, insertable = true, updatable = true)
	private Date mesCompetencia;	
	
	@ManyToOne
	@JoinColumn(name = "IdEmpresa")
	private Empresa empresaFolha;
		
	 @OneToMany(mappedBy = "folhaPagamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private Collection<Evento> eventos;
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMesCompetencia() {
		return mesCompetencia;
	}

	public void setMesCompetencia(Date mesCompetencia) {
		this.mesCompetencia = mesCompetencia;
	}

	public Empresa getEmpresaFolha() {
		return empresaFolha;
	}

	public void setEmpresaFolha(Empresa empresaFolha) {
		this.empresaFolha = empresaFolha;
	}

	public Collection<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Collection<Evento> eventos) {
		this.eventos = eventos;
	}
		

}
