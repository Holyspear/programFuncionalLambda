package application;

import java.util.ArrayList;
import java.util.Collections;
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
		
		Collections.sort(list);
		
		for(Product product : list) {
			System.out.println(product);
		}
		
	}

}