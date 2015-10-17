package br.jasper_webapp.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;

	private String nome;
	private Date nascimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Profissao profissao;


	public Pessoa() {
	}


	public Pessoa(String nome, Date nascimento, Profissao profissao) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.profissao = profissao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public Profissao getProfissao() {
		return profissao;
	}


	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	
	
	
	

}
