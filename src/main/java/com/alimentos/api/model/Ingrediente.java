package com.alimentos.api.model;

import java.math.BigDecimal;

public class Ingrediente {

	private Integer id;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(Integer id, String nome, Integer quantidade, BigDecimal preco) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
