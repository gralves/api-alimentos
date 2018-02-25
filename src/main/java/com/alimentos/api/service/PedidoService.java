package com.alimentos.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alimentos.api.model.Lanche;
import com.alimentos.api.model.Pedido;

@Service
public class PedidoService {


	@Autowired
	private LancheService lancheService;
	
	

	public Pedido adicionaPedido(Pedido pedido) {

		BigDecimal totalPedido = BigDecimal.ZERO;
		
		for(Lanche lanche : pedido.getLanches()) {

			
			totalPedido = totalPedido.add(lancheService.calculaTotalIngredientes(lanche.getIngredientes()));

		}
		pedido.setTotalPedido(totalPedido);
		
		
		return pedido;
	}
	


	public LancheService getLancheService() {
		return lancheService;
	}

	public void setLancheService(LancheService lancheService) {
		this.lancheService = lancheService;
	}

	

	

	





}
