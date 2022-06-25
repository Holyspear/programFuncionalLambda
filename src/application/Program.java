package application;

import java.util.ArrayList;
import java.util.Comparator;
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
		
		//Declarar um Comparator utilizando sintaxe de classe anônima,
		//Para remover a instanciação da classe MyComparator.
		Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product product1, Product product2) {
				return product1.getName().toLowerCase().compareTo(product2.getName().toLowerCase());
			}			
		};
		
		list.sort(comp);
		
		for(Product product : list) {
			System.out.println(product);
		}		
	}
}