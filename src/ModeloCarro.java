package br.com.vinicius.aula3.questao10.exercicio01;

public class ModeloCarro {
	private String modelo;
	private int ano;
	private double preco;
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getPreco() {
		return preco;
	}
	public Integer getAnoDaVenda() {
		return ano;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAno(int ano) {
		this.ano = ano;
		
	}

	public String getModelo() {
		return modelo;
	}
	
	
}
