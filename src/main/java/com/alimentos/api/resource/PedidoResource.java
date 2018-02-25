package com.alimentos.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.alimentos.api.model.Pedido;
import com.alimentos.api.service.PedidoService;

@RequestMapping("/pedido")
@RestController
public class PedidoResource {
	
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido addPedido(@Valid @RequestBody Pedido pedido) {
	 return pedidoService.adicionaPedido(pedido);
	}
	

}
