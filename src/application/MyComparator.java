package application;

import java.util.Comparator;

import model.entities.Product;

public class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		return product1.getName().toLowerCase().compareTo(product2.getName().toLowerCase());
	}
}
