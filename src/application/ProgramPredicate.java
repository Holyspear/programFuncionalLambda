package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class ProgramPredicate {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Implementando através de um método NÃO estático na classe Product
		list.removeIf(Product::nonstaticProductPredicate);
		
		for (Product product : list) {
			System.out.println(product);
		}

	}

}
