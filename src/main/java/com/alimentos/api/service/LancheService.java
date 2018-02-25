package com.alimentos.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alimentos.api.model.Ingrediente;
import com.alimentos.api.model.Lanche;

@Service
public class LancheService {

	private static final List<Lanche> lancheList = new ArrayList<>();
	private static final List<Ingrediente> ingredienteList = new ArrayList<>();

	 static {
		 
		Ingrediente alface = new Ingrediente(1, "Alface", 1, BigDecimal.valueOf(0.40));
		Ingrediente bacon = new Ingrediente(2, "Bacon", 1, BigDecimal.valueOf(2));
		Ingrediente hamburguer = new Ingrediente(3, "Hamburguer de Carne",1, BigDecimal.valueOf(3));
		Ingrediente ovo = new Ingrediente(4, "Ovo",1, BigDecimal.valueOf(0.80));
		Ingrediente queijo = new Ingrediente(5, "Queijo", 1, BigDecimal.valueOf(1.50));


		Lanche xBacon = new Lanche(1, "X-Bacon", new ArrayList<>(Arrays.asList(bacon,hamburguer,queijo)));
		Lanche xBurger = new Lanche(2, "X-Burger", new ArrayList<>(Arrays.asList(hamburguer,queijo)));
		Lanche xEgg = new Lanche(3, "X-Egg", new ArrayList<>(Arrays.asList(ovo,hamburguer,queijo)));
		Lanche xEggBacon = new Lanche(4, "X-Egg Bacon", new ArrayList<>(Arrays.asList(ovo,bacon,hamburguer,queijo)));

		lancheList.addAll(new ArrayList<>(Arrays.asList(xBacon, xBurger, xEgg, xEggBacon)));
		ingredienteList.addAll(new ArrayList<>(Arrays.asList(alface, bacon, hamburguer, ovo, queijo)));

	}
	 
	 	public Lanche getLancheById(Integer idLanche) {
		 	
			Optional<Lanche> lanche = lancheList
		            .stream()
		            .filter(l -> idLanche == l.getId())
		            .findFirst();
			
			if (lanche.isPresent()) {
				 return lanche.get();
			}

			return null;

		}

		public BigDecimal calculaTotalIngredientes(List<Ingrediente> listIngrediente) {

			BigDecimal item;
			BigDecimal total = BigDecimal.ZERO;
			Integer quantidadePromocao = 0;
			
			boolean temAlface = false;
			boolean temBacon = false;

			for (Ingrediente ingrediente : listIngrediente) {

				if ((ingrediente.getId() == 1 && ingrediente.getQuantidade() >= 1) ) {
					temAlface = true;
				}

				if ((ingrediente.getId() == 2 && ingrediente.getQuantidade() >= 1)) {
					temBacon = true;
				}

				if ((ingrediente.getId() == 3 || ingrediente.getId() == 5) && (ingrediente.getQuantidade() % 3 == 0)) {
					quantidadePromocao = (ingrediente.getQuantidade() / 3) * 2;
					item = (ingrediente.getPreco().multiply(new BigDecimal(quantidadePromocao)));
				}
				else {
					item = (ingrediente.getPreco().multiply(new BigDecimal(ingrediente.getQuantidade())));
				}
				total = total.add(item);

			}

			if (temAlface && !temBacon) {
				
				total = total.subtract(total.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
			}

			return total;
		}

		public BigDecimal calculaValorLanche(Integer idLanche) {
			
			Lanche lanche = getLancheById(idLanche);
			return calculaTotalIngredientes(lanche.getIngredientes());
			
		}
		

		public List<Lanche> toListLanches() {
			for(Lanche l : lancheList) {
				l.setValorTotalLanche(calculaValorLanche(l.getId()));
			}
				
			return lancheList;
		}
		
		public List<Ingrediente> toListIngredientes() {
			return ingredienteList;
		}

}
