package com.alimentos.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alimentos.api.model.Ingrediente;
import com.alimentos.api.model.Lanche;
import com.alimentos.api.service.LancheService;

@RequestMapping("/lanche")
@RestController
public class LancheResource {
	
	
	@Autowired
	private LancheService lancheService;
	
	@RequestMapping(value = "list-lanches", method = RequestMethod.GET)
	public List<Lanche> getAllLanches() {
		return lancheService.toListLanches();
	}

	@RequestMapping(value = "list-ingredientes", method = RequestMethod.GET)
	public List<Ingrediente> getAllIngredientes() {
		return lancheService.toListIngredientes();
	}

	
}
