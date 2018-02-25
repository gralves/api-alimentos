package com.alimentos.api.model;

import java.math.BigDecimal;
import java.util.List;

public class Lanche {

	private Integer id;
	private String nome;
	private List<Ingrediente> ingredientes;
	private BigDecimal valorTotalLanche;
	
	public BigDecimal getValorTotalLanche() {
		return valorTotalLanche;
	}

	public void setValorTotalLanche(BigDecimal valorTotalLanche) {
		this.valorTotalLanche = valorTotalLanche;
	}

	public Lanche(Integer id, String nome, List<Ingrediente> ingredientes) {
		super();
		this.id = id;
		this.nome= nome;
		this.ingredientes = ingredientes;
	}
	
	public Lanche() {
		
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
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
	
}
