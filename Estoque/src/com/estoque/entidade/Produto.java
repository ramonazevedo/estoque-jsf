package com.estoque.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@Column	
	private Date dataCadastrada;
	@Column		
	private String unidadeProduto;
	
	/*
	 * 
	 * 
	 * 
	 * 	   GETS AND SETS			
	 * 
	 * 
	 * 	 
	 */
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastrada() {
		return dataCadastrada;
	}
	public void setDataCadastrada(Date dataCadastrada) {
		this.dataCadastrada = dataCadastrada;
	}
	public String getUnidadeProduto() {
		return unidadeProduto;
	}
	public void setUnidadeProduto(String unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}

	public int getId() {
		return id;
	}

}