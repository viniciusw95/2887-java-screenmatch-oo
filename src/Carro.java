package br.com.vinicius.aula3.questao10.exercicio01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Carro {
	private String modeloAnalisado = null;
	private VendasPorAno registradas = null;
	private Double maiorPreco = null;
	private Double menorPreco = null;
	
	public Carro() {		
		registradas = new VendasPorAno(); 
	
	}	
	
	private class VendasPorAno extends HashMap<Integer, ArrayList<ModeloCarro>> {
		
		private static final long serialVersionUID = 1L;

		public VendasPorAno() {
			
		}
		
		private double precoMedio(int desteAno) {
			ArrayList<ModeloCarro> vendas = get(desteAno);
			double precoSomado = 0;
			for (int i = 0; i < vendas.size(); i++) {			       
				precoSomado += vendas.get(i).getPreco();
			}
			return precoSomado / (double) vendas.size();
		}
		
		public void incluirVenda(ModeloCarro modelo) {
			if (possuirEspaco(modelo)) {
				get(modelo.getAnoDaVenda()).add(modelo);
				checaSeMaiorPreco(modelo);
				checaSeMenorPreco(modelo);
				return;
			}
			System.out.println("ano fora do intervalo permitido");
			
		}
		
		private boolean possuirEspaco(ModeloCarro modelo) {
			int anoDaVenda = modelo.getAnoDaVenda();
			
			if (isEmpty()) {
				put(anoDaVenda, new ArrayList<ModeloCarro>());
				put(anoDaVenda + 1, new ArrayList<ModeloCarro>());
				put(anoDaVenda + 2, new ArrayList<ModeloCarro>());
				modeloAnalisado = modelo.getModelo();
				return true;
			}
			
			if (containsKey(anoDaVenda) && modelo.getModelo().equals(modeloAnalisado)) {
				return true;
			} else {
				return false;
			}			
		}
		private void checaSeMaiorPreco(ModeloCarro modelo) {
			if (maiorPreco == null || modelo.getPreco() > maiorPreco) {
				maiorPreco = modelo.getPreco();
			}
		}
		private void checaSeMenorPreco(ModeloCarro modelo) {
			if (menorPreco == null || modelo.getPreco() < menorPreco) {
				menorPreco = modelo.getPreco();
			}
		}
		
	}
	
	public void incluirVenda(ModeloCarro modelo) throws NullPointerException {
		registradas.incluirVenda(modelo);		
	}
	
	public void mostrarVendas(int desteAno) {
		registradas.get(desteAno).forEach(carro -> {
			System.out.println("Ano: " + desteAno + " Preço: " + carro.getPreco());
		});
	}
	
	public double precoMedio(int desteAno) {
		double precoSomado = registradas.precoMedio(desteAno);
		return precoSomado;
	}
	
	public double maiorPreco() {
		return maiorPreco;
	}
	public double menorPreco() {
		return menorPreco;
	}
}
