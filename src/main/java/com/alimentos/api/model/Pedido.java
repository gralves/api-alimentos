package com.alimentos.api.model;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
	
		private Integer id;
		private List<Lanche> lanches;
		private BigDecimal totalPedido;
		private List<String> promocoes;

		public List<String> getPromocoes() {
			return promocoes;
		}

		public void setPromocoes(List<String> promocoes) {
			this.promocoes = promocoes;
		}

		public Pedido() {

		}

		public Pedido(List<Lanche> lanches, BigDecimal totalPedido) {
			super();

			this.lanches = lanches;
			this.totalPedido = totalPedido;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<Lanche> getLanches() {
			return lanches;
		}

		public void setLanches(List<Lanche> lanches) {
			this.lanches = lanches;
		}

		public BigDecimal getTotalPedido() {
			return totalPedido;
		}

		public void setTotalPedido(BigDecimal totalPedido) {
			this.totalPedido = totalPedido;
		}

}
