package br.com.vinicius.aula3.questao10.exercicio01;

public class TestaCarro {

	public static void main(String[] args) {

		Carro c = new Carro();
		ModeloCarro m = new ModeloCarro();
		m.setAno(2010);
		m.setPreco(10000);
		m.setModelo("Uno");
		ModeloCarro m1 = new ModeloCarro();
		m1.setAno(2010);
		m1.setModelo("Uno");
		m1.setPreco(11000);
		ModeloCarro m2 = new ModeloCarro();
		m2.setAno(2010);
		m2.setPreco(12000);
		m2.setModelo("Uno");
		ModeloCarro m3 = new ModeloCarro();
		m3.setAno(2010);
		m3.setPreco(13000);
		m3.setModelo("Uno");
		c.incluirVenda(m);
		c.incluirVenda(m1);
		c.incluirVenda(m2);
		c.incluirVenda(m3);
		c.mostrarVendas(2010);
		
		try {			
			System.out.println(c.precoMedio(2010));
			System.out.println("maior preço: " + c.maiorPreco());
			System.out.println("menor preço: " + c.menorPreco());
		} catch (ArithmeticException ae) {
			System.out.println("nenhum modelo saldo, rezultando em div por 0.");
		}
	}

}
