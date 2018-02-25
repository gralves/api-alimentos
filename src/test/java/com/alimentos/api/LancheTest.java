package com.alimentos.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alimentos.api.resource.LancheResource;


public class LancheTest extends AlimentosApiApplicationTest{
	
	private MockMvc mockMvc;
	
    
	@Autowired
	private LancheResource lancheResource;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(lancheResource).build();
	}
	
	@Test
	public void listaLanchesComPreco() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/lanche/list-lanches")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
}
