package com.alimentos.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alimentos.api.model.Ingrediente;
import com.alimentos.api.model.Lanche;
import com.alimentos.api.model.Pedido;
import com.alimentos.api.resource.PedidoResource;
import com.alimentos.api.service.LancheService;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PedidoTest extends AlimentosApiApplicationTest{
	
	private MockMvc mockMvc;
    
	@Autowired
	private PedidoResource pedidoResource;
	
	@Autowired
	private LancheService lancheService;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(pedidoResource).build();
	}
	
	
	
	@Test
	public void testPOSTSavePedido() throws Exception {
		

		ObjectMapper mapper = new ObjectMapper();
		
		
		Pedido pedidoRequest = new Pedido();
		pedidoRequest.setLanches(lanches());
		
		String content = mapper.writeValueAsString(pedidoRequest);
		

		this.mockMvc.perform(post("/pedido/save").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isCreated());
	}
	
	public List<Lanche> lanches(){
		
		List<Lanche> lista = new ArrayList<>();
		
		Lanche lanche1 = lancheService.getLancheById(1);
		lista.add(lanche1);
		
		Lanche lanche2 = lancheService.getLancheById(1);
		lista.add(lanche2);
		
		List<Ingrediente> ingredientes = lancheService.toListIngredientes();
		
		List<Ingrediente> ingLanche = new ArrayList<>();
		Ingrediente ing1 = new Ingrediente();
		ing1.setId(ingredientes.get(1).getId());
		ing1.setQuantidade(1);
		ing1.setPreco(ingredientes.get(1).getPreco());
		ingLanche.add(ing1);
		
		Ingrediente ing2 = new Ingrediente();
		ing2.setId(ingredientes.get(2).getId());
		ing2.setQuantidade(2);
		ing2.setPreco(ingredientes.get(2).getPreco());
		ingLanche.add(ing2);
		
		
		Lanche lanche3 = new Lanche();
		lanche3.setIngredientes(ingLanche);
		lista.add(lanche3);
		
		return lista;
	}
	
}
