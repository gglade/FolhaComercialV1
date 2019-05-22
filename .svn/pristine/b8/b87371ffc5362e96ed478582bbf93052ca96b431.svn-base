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
public class Usuario {
	
	@Id
	@Column(name = "username")
	@GeneratedValue(generator = "SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "hibernate_sequence", name = "SEQ", allocationSize = 1)
	private String  username;
	
	private String password;
	
	@Column(name = "enable", columnDefinition= "BOOLEAN")
	private boolean enable;
	
	
	@OneToMany(mappedBy = "username")
	private Collection<Autorizacao> autorizacoes;
	


	public Usuario(){
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Collection<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
	public void setAutorizacoes(Collection<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	
}
