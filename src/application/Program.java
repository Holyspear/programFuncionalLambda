package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		
		//Implementei uma interface Comparator do tipo Product para
		//sobrescrever o método compare da interface. O método vai
		//comparar os nomes dos produtos formatados em minúsculo
		//Essa classe vai permitir utilizar um Sort da estrutura List.
		list.sort(new MyComparator());
		
		for(Product product : list) {
			System.out.println(product);
		}		
	}
}